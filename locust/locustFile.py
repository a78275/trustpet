import random
import json
from locust import HttpLocust, TaskSet, task, seq_task, TaskSequence
from credentials import DONO_CREDENTIALS, PETSITTER_CREDENTIALS


class PedidoBehavior(TaskSequence):
    token=""
    animais = []

    def on_start(self):
        if self.parent.animais is None or self.parent.token == "" or self.parent.animais == []:
            print("Não tem login de Dono feito com animais")
            self.interrupt()
        else:
            self.token = self.parent.token
            self.animais = self.parent.animais

    @seq_task(1)
    def registarPedido(self):
        print(str(self.animais))
        packet_data = "{'animais': " + str(self.animais) + ", 'dataInicio': '20/05/2019 17:00','dataFim': '20/03/2020 19:00'}"
        response = self.client.request("POST", "/RegistarPedido", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        dict_response = json.loads(response.text)
        if dict_response["success"]:
            print("RegistarPedido Response " + str(response) + " with idPedido " + dict_response["idPedido"] + " with Servicos " + dict_response["servicos"])
        else:
            print("BAD PEDIDO")
    # @seq_task(2)
    # def selServicos():

    # @seq_task(3)
    # def selPetsitter():

class DonoBehavior(TaskSet):
    tasks = {PedidoBehavior:10}
    token = ""
    animais = []

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

    @task(10)
    def consultarAnimais(self):
        response = self.client.request("GET", "/ConsultarAnimais",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        dict_response = json.loads(response.text)
        if "animais" in dict_response:
            print("ConsultarAnimais Response " + str(response) + " with Animals Count " + str(len(dict_response["animais"])))
            self.animais = dict_response["animais"]

    @task(10)
    def consultarPedidos(self):
        response = self.client.request("GET", "/ConsultarPedidos",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarPedidos Response " + str(response) + " with Pedidos " + str(response.text))

    @task(10)
    def consultarPerfil(self):
        response = self.client.request("GET", "/ConsultarPerfil",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarPerfil Response " + str(response) + " with Perfil " + str(response.text))

    @task(10)
    def consultarPetsitters(self):
        response = self.client.request("GET", "/ConsultarPetsitters",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        dict_response = json.loads(response.text)
        print("ConsultarPetsitters Response " + str(response) + " with Petsitters Count " + str(len(dict_response["petsitters"])))

    @task(10)
    def consultarPerfilPost(self):
        packet_data = "{'emailConsulta':'petsitter1@email.com'}"
        response = self.client.request("POST", "/ConsultarPerfil", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("EditarDados Response " + str(response) + " with Success " + str(response.text))

    @task(5)
    def adicionarAnimal(self):
        packet_data = "{'nome':'Maniche','idade':'Jovem','porte':'Pequeno','sexo':'F','alergias':'a','doencas':'b','comportamento':'c','vacinas':'true','desparasitacao':'true','esterilizacao':'true','raca':'Engodo2','avatar':'','emailDono':'email1@email.com','tipo':'1','ativo':'true'}"
        response = self.client.request("POST", "/EditarAnimal", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("AdicionarAnimal Response " + str(response) + " with Success " + str(response.text))

    @task(5)
    def editarDadosPessoais(self):
        packet_data = "{'nome':'João','data':'20/10/1969','contacto':'3182937','jardim':'true','morada':'Rua A','password':'ola','avatar':'','tipoUtilizador':'dono','concelho':'Porto','distrito':'Porto'}"
        response = self.client.request("POST", "/EditarDadosPessoais", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("EditarDados Response " + str(response) + " with Success " + str(response.text))

    #def cancelarPedido

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

    @task(10)
    def consultarPerfil(self):
        response = self.client.request("GET", "/ConsultarPerfil",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarPerfil Response " + str(response) + " with Perfil " + str(response.text))

    @task(10)
    def consultarPedidos(self):
        response = self.client.request("GET", "/ConsultarPedidos",
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarPedidos Response " + str(response) + " with Pedidos " + str(response.text))

    @task(10)
    def consultarPerfilPost(self):
        packet_data = "{'emailConsulta':'dono1@email.com'}"
        response = self.client.request("POST", "/ConsultarPerfil", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("EditarDados Response " + str(response) + " with Success " + str(response.text))

    @task(5)
    def editarDadosPessoais(self):
        packet_data = "{'nome':'João','data':'20/10/1969','contacto':'3182937','jardim':'true','morada':'Rua A','password':'ola','avatar':'','tipoUtilizador':'petsitter','concelho':'Porto','distrito':'Porto'}"
        response = self.client.request("POST", "/EditarDadosPessoais", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("EditarDados Response " + str(response) + " with Success " + str(response.text))

    @task(5)
    def editarTipos(self):
        packet_data = "{'tipos':['1','2','3','4']}"
        response = self.client.request("POST", "/EditarTiposAnimais", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("EditarTipos Response " + str(response) + " with Success " + str(response.text))

    @task(5)
    def editarServicos(self):
        packet_data = "{'servicos':['1:3.5','2:4.7','3:2']}"
        response = self.client.request("POST", "/EditarServicos", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("EditarServicos Response " + str(response) + " with Success " + str(response.text))

    #def editarHorario
    #def cancelarPedido

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
