import random
import json
from locust import HttpLocust, TaskSet, task
from credentials import DONO_CREDENTIALS, PETSITTER_CREDENTIALS


class DonoBehavior(TaskSet):
    token = ""

    def on_start(self):
        if self.parent.token is None or self.parent.token == "" or self.parent.tipo != "dono":
            print("Não tem login de Dono feito")
            self.interrupt()
        else:
            self.token = self.parent.token

    def on_stop(self):
        """ on_stop is called when the TaskSet is stopping """
        pass

    @task(0)
    def logout(self):
        response = self.client.request("POST", "/Logout",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("Logout Response " + str(response) + " with Success " + str(response.text))
        self.token = ""
        self.interrupt()

    @task(5)
    def consultarAnimais(self):
        response = self.client.request("GET", "/ConsultarAnimais",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarAnimais Response " + str(response) + " with Animals " + str(response.text))

    @task(5)
    def consultarPedidos(self):
        response = self.client.request("GET", "/ConsultarPedidos",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarPedidos Response " + str(response) + " with Pedidos " + str(response.text))

    @task(5)
    def consultarPerfil(self):
        response = self.client.request("GET", "/ConsultarPerfil",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarPerfil Response " + str(response) + " with Perfil " + str(response.text))

    @task(5)
    def consultarPetsitters(self):
        response = self.client.request("GET", "/ConsultarPetsitters",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        dict_response = json.loads(response.text)
        print("ConsultarPetsitters Response " + str(response) + " with Petsitters Count " + str(len(dict_response["petsitters"])))

    @task(5)
    def adicionarAnimal(self):
        packet_data = "{'nome':'Maniche','idade':'Jovem','porte':'Pequeno','sexo':'F','alergias':'a','doencas':'b','comportamento':'c','vacinas':'true','desparasitacao':'true','esterilizacao':'true','raca':'Engodo2','avatar':'','emailDono':'email1@email.com','tipo':'1','ativo':'true'}"
        response = self.client.request("POST", "/EditarAnimal", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("AdicionarAnimal Response " + str(response) + " with Success " + str(response.text))

    #def editarDadosPessoais
    #def registarPedido
    #def selServicos
    #def selPetsitter
    #def cancelarPedido
    #def consultarPerfilPost

class PetsitterBehavior(TaskSet):
    token=""

    def on_start(self):
        if self.parent.token is None or self.parent.token == "" or self.parent.tipo != "petsitter":
            print("Não tem login de Petsitter feito")
            self.interrupt()
        else:
            self.token = self.parent.token

    @task(0)
    def logout(self):
        response = self.client.request("POST", "/Logout",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("Logout Response " + str(response) + " with Success " + str(response.text))
        self.token = ""
        self.interrupt()

    @task(5)
    def consultarPerfil(self):
        response = self.client.request("GET", "/ConsultarPerfil",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarPerfil Response " + str(response) + " with Perfil " + str(response.text))

    @task(5)
    def consultarPedidos(self):
        response = self.client.request("GET", "/ConsultarPedidos",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarPedidos Response " + str(response) + " with Pedidos " + str(response.text))

    #def editarDadosPessoais
    #def editarTipos
    #def editarServicos
    #def cancelarPedido
    #def consultarPerfilPost

class IndexBehavior(TaskSet):
    tasks = {DonoBehavior:10,PetsitterBehavior:10}
    token = ""
    email = ""
    tipo = ""

    def on_start(self):
        if bool(random.getrandbits(1)) :
            if len(PETSITTER_CREDENTIALS) > 0:
                self.email = PETSITTER_CREDENTIALS.pop()
        else:
            if len(DONO_CREDENTIALS) > 0:
                self.email = DONO_CREDENTIALS.pop()

    @task(5)
    def index(self):
        response = self.client.request("GET", "/Index",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("Index Response " + str(response) + " with Tipo " + str(response.text))

    @task(25)
    def login(self):
        packet_data = "{'email':'" + self.email + "', 'password':'ola'}"
        response = self.client.request("POST", "/Autenticar", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded"})
        dict_response = json.loads(response.text)
        if "success" in dict_response and dict_response["success"] == True:
            self.token=dict_response["token"]
            self.tipo=dict_response["tipo"]
            print("Login with Email " + self.email + " with Token " + str(self.token) + " with Tipo " + dict_response["tipo"])
            if self.tipo=="dono":
                self.locust.tasks = DonoBehavior
            else:
                self.locust.tasks = PetsitterBehavior
        else:
            print("Failed Login")

    #@task(1)
    def registarDono(self):
        packet_data = "{'email':'" + self.email + "','nome':'Nestor','contacto':'112','jardim':'true','morada':'Rua X','password':'ola','avatar':'','concelho':'Porto','distrito':'Porto','dataNasc':'20/03/1999'}"
        response = self.client.request("POST", "/RegistarDono", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded"})
        print("ID" + self.email + "RegistarDono Response: " + str(response) + " with Success " + str(response.text))

    #@task(1)
    def registarPetsitter(self):
        packet_data = "{'email':'" + self.email + "','nome':'Jose','contacto':'112','jardim':'true','morada':'Rua X','password':'ola','avatar':'','concelho':'Porto','distrito':'Porto','dataNasc':'20/03/1999'}"
        response = self.client.request("POST", "/RegistarPetsitter", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded"})
        print("ID" + self.email + "RegistarPetsitter Response: " + str(response) + " with Success " + str(response.text))
        self.wait()


class WebsiteUser(HttpLocust):
    task_set = IndexBehavior
    min_wait = 1000
    max_wait = 5000
    host = "http://localhost:8080/trustpet_war_exploded"

    def __init__(self):
        super(WebsiteUser, self).__init__()
        global PETSITTER_CREDENTIALS, DONO_CREDENTIALS
