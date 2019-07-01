import random
import json
from locust import HttpLocust, TaskSet, task, seq_task, TaskSequence
from credentials import DONO_CREDENTIALS, PETSITTER_CREDENTIALS

class PedidoBehavior(TaskSequence):
    token = ""
    animais = []
    servicos = []
    petsitter = ""
    id = 0

    def on_start(self):
        if self.parent.animais is None or self.parent.token == "" or self.parent.animais == []:
            print("Não tem login de Dono feito com animais")
            self.interrupt()
        else:
            self.token = self.parent.token
            self.animais = self.parent.animais

    @seq_task(1)
    def registarPedido(self):
        lenght = len(self.animais)
        if lenght > 0:
            animais = []
            if lenght > 3:
                for i in range(0,3):
                    animais.append(self.animais[i]["id"])
            else:
                for a in self.animais:
                    animais.append(a["id"])
            animais_json = json.dumps(animais)
            packet_data = "{'animais': " + animais_json + ", 'dataInicio': '30/06/2019 12:00','dataFim': '30/06/2019 13:00'}"
            response = self.client.request("POST", "/RegistarPedido", data=packet_data, catch_response=True,
                                           headers={"Content-Type": "application/x-www-form-urlencoded",
                                                    "Token": self.token})
            dict_response = json.loads(response.text)
            if dict_response["success"] and dict_response["success"] == True:
                print("RegistarPedido Response " + str(response) + " with idPedido " + str(dict_response[
                    "idPedido"]) + " with Servicos " + str(dict_response["servicos"]))
                self.servicos = dict_response["servicos"]
                self.id = dict_response["idPedido"]
                response.success()
            else:
                print("Pedido Inválido")
                response.failure("Erro")
                self.interrupt()
        else:
            self.interrupt()

    @seq_task(2)
    def selServicos(self):
        if len(self.servicos) > 0 and self.id != 0:
            servicos = []
            for servico_animal in self.servicos:
                index_servico = random.randint(0,len(servico_animal["servicos"])-1)
                servico_string = str(servico_animal["id"])  + ":" + str(servico_animal["servicos"][index_servico]["id"])
                servicos.append(servico_string)

            servicos_json = json.dumps(servicos)
            packet_data = "{'idPedido': '" + str(self.id) + "', 'animalServicos': " + servicos_json + "}"
            response = self.client.request("POST", "/SelServicos", data=packet_data, catch_response=True, headers={"Content-Type": "application/x-www-form-urlencoded","Token": self.token})
            if response.status_code == 200:
                dict_response = json.loads(response.text)

                if dict_response["success"] and dict_response["success"] == True:
                    print("SelServicos Response " + str(response) + " with Petsitters count" + str(len(dict_response["petsitters"])) + " including " + str(dict_response["petsitters"][0:1]))
                    if len(dict_response["petsitters"]) > 0:
                        index_petsitter = random.randint(0, len(dict_response["petsitters"]) - 1)
                        self.petsitter = dict_response["petsitters"][index_petsitter]["email"]
                        response.success()
                    else:
                        print("Não há petsitters")
                        self.interrupt()
                else:
                    print("Selecao Inválida")
                    self.interrupt()
            else:
                print("Erro")
                response.failure("Erro")
                self.interrupt()
        else:
            print("Não há serviços")
            self.interrupt()

    @seq_task(3)
    def selPetsitter(self):
        if self.petsitter != "":
            packet_data = "{'idPedido': '" + str(self.id) + "', 'email': " + self.petsitter + "}"
            response = self.client.request("POST", "/SelPetsitter", data=packet_data, catch_response=True,
                                           headers={"Content-Type": "application/x-www-form-urlencoded",
                                                    "Token": self.token})
            if response is not None:
                dict_response = json.loads(response.text)
                if dict_response["success"] and dict_response["success"] == True:
                    print("ConcluirPedido Response " + str(response) + " with success " + str(dict_response["success"]))
                    response.success()
                else:
                    print("Pedido Falhado")
                    response.failure("Erro")
                    self.interrupt()
            else:
                print("Pedido Falhado")
                response.failure("Erro")
                self.interrupt()


class DonoBehavior(TaskSet):
    tasks = {PedidoBehavior:40}
    token = ""
    animais = []
    pedidos = []

    def on_start(self):
        if self.parent.token is None or self.parent.token == "" or self.parent.tipo != "dono":
            print("Não tem login de Dono feito")
            self.interrupt()
        else:
            self.token = self.parent.token

    @task(40)
    def consultarAnimais(self):
        response = self.client.request("GET", "/ConsultarAnimais", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "animais" in dict_response and dict_response["success"] == True:
                print("ConsultarAnimais Response " + str(response) + " with Animals Count " + str(len(dict_response["animais"])))
                self.animais = json.loads(dict_response["animais"])
        else:
            response.failure("Erro")

    @task(20)
    def consultarPerfil(self):
        response = self.client.request("GET", "/ConsultarPerfil", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if dict_response["success"] and dict_response["success"] == True:
                print("ConsultarPerfil Response " + str(response) + " with Perfil " + str(dict_response["utilizador"]))
        else:
            response.failure("Erro")

    @task(20)
    def consultarPetsitters(self):
        response = self.client.request("GET", "/ConsultarPetsitters", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if dict_response["success"] and dict_response["success"] == True:
                print("ConsultarPetsitters Response " + str(response) + " with Petsitters Count " + str(len(dict_response["petsitters"])))
        else:
            response.failure("Erro")

    @task(20)
    def consultarPedidos(self):
        response = self.client.request("GET", "/ConsultarPedidos", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "pedidos" in dict_response and dict_response["success"] == True:
                self.pedidos = dict_response["pedidos"]
                print("ConsultarPedidos Response " + str(response) + " with Pedidos " + str(len(self.pedidos)))
        else:
            response.failure("Erro")

    @task(20)
    def consultarPerfilPost(self):
        packet_data = "{'emailConsulta':'petsitter999@email.com'}"
        response = self.client.request("POST", "/ConsultarPerfil", catch_response=True, data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                print("ConsultarPerfilPost Response " + str(response) + " with Success " + str(response.text))
        else:
            response.failure("Erro")

    @task(20)
    def adicionarAnimal(self):
        packet_data = "{'nome':'Maniche','idade':'Jovem','porte':'Pequeno','sexo':'F','alergias':'a','doencas':'b','comportamento':'c','vacinas':'true','desparasitacao':'true','esterilizacao':'true','raca':'Engodo2','avatar':'','tipo':'1'}"
        response = self.client.request("POST", "/EditarAnimal", catch_response=True, data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                print("AdicionarAnimal Response " + str(response) + " with Success " + str(response.text))
        else:
            response.failure("Erro")

    @task(10)
    def editarAnimal(self):
        if len(self.animais) > 0:
            idanimal = self.animais[0]["id"]
            packet_data = "{'id':'" + str(idanimal) + "','nome':'Manichu','idade':'Velho','porte':'Grande','sexo':'M','alergias':'a','doencas':'b','comportamento':'c','vacinas':'true','desparasitacao':'true','esterilizacao':'true','raca':'Engodo2','avatar':'','tipo':'1'}"
            response = self.client.request("POST", "/EditarAnimal", catch_response=True, data=packet_data,
                                           headers={"Content-Type": "application/x-www-form-urlencoded",
                                                    "Token": self.token})
            if response.status_code == 200:
                response.success()
                dict_response = json.loads(response.text)
                if "success" in dict_response and dict_response["success"] == True:
                    print("EditarAnimal Response " + str(response) + " with Success " + str(response.text))
            else:
                response.failure("Erro")
        else:
            print("Edição não é possível sem animais")

    @task(10)
    def editarDadosPessoais(self):
        packet_data = "{'nome':'João','dataNasc':'20/10/1969','contacto':'3182937','jardim':'true','morada':'Rua A','password':'ola','avatar':'','concelho':'Porto','distrito':'Porto'}"
        response = self.client.request("POST", "/EditarDadosPessoais", catch_response=True, data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                print("EditarDados Response " + str(response) + " with Success " + str(response.text))
        else:
            response.failure("Erro")

    @task(5)
    def logout(self):
        response = self.client.request("GET", "/Logout", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                self.token = ""
                print("Logout Response " + str(response) + " with Success " + str(response.text))
                self.interrupt()
        else:
            response.failure("Erro")

    @task(1)
    def removerAnimal(self):
        if len(self.animais) > 0:
            idanimal = self.animais.pop()["id"]
            packet_data = "{'id':'" + str(idanimal) + "','ativo':'false'}"
            response = self.client.request("POST", "/EditarAnimal", catch_response=True, data=packet_data,
                                           headers={"Content-Type": "application/x-www-form-urlencoded",
                                                    "Token": self.token})
            if response.status_code == 200:
                response.success()
                dict_response = json.loads(response.text)
                if "success" in dict_response and dict_response["success"] == True:
                    print("RemoverAnimal Response " + str(response) + " with Success " + str(response.text))
            else:
                response.failure("Erro")
        else:
            print("Remoção não é possível sem animais")

    @task(1)
    def cancelarPedido(self):
        if len(self.pedidos) > 0:
            idpedido = self.pedidos.pop()["id"]
            packet_data = "{'idPedido':'" + str(idpedido) + "'}"
            response = self.client.request("POST", "/CancelarPedido", catch_response=True, data=packet_data,headers={"Content-Type": "application/x-www-form-urlencoded","Token": self.token})
            if response.status_code == 200:
                response.success()
                dict_response = json.loads(response.text)
                if "success" in dict_response and dict_response["success"] == True:
                    print("CancelarPedido Response " + str(response) + " with Success " + str(response.text))
            else:
                response.failure("Erro")
        else:
            print("Sem pedidos para cancelar")


class PetsitterBehavior(TaskSet):
    token = ""
    pedidos = []

    def on_start(self):
        if self.parent.token is None or self.parent.token == "" or self.parent.tipo != "petsitter":
            print("Não tem login de Petsitter feito")
            self.interrupt()
        else:
            self.token = self.parent.token

    @task(40)
    def consultarPerfil(self):
        response = self.client.request("GET", "/ConsultarPerfil", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if dict_response["success"] and dict_response["success"] == True:
                print("ConsultarPerfil Response " + str(response) + " with Perfil " + str(dict_response["utilizador"]))
        else:
            response.failure("Erro")

    @task(20)
    def consultarPedidos(self):
        response = self.client.request("GET", "/ConsultarPedidos", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "pedidos" in dict_response and dict_response["success"] == True:
                self.pedidos = dict_response["pedidos"]
                print("ConsultarPedidos Response " + str(response) + " with Pedidos " + str(len(self.pedidos)))
        else:
            response.failure("Erro")

    @task(20)
    def consultarPerfilPost(self):
        packet_data = "{'emailConsulta':'dono999@email.com'}"
        response = self.client.request("POST", "/ConsultarPerfil", catch_response=True, data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                print("ConsultarPerfilPost Response " + str(response) + " with Success " + str(response.text))
        else:
            response.failure("Erro")

    @task(10)
    def editarDadosPessoais(self):
        packet_data = "{'nome':'João','dataNasc':'20/10/1969','contacto':'3182937','jardim':'true','morada':'Rua A','password':'ola','avatar':'','concelho':'Porto','distrito':'Porto'}"
        response = self.client.request("POST", "/EditarDadosPessoais", catch_response=True, data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                print("EditarDados Response " + str(response) + " with Success " + str(response.text))
        else:
            response.failure("Erro")

    @task(5)
    def editarServicos(self):
        packet_data = "{'servicos':['1:3.5','2:4.7','3:2','4:5']}"
        response = self.client.request("POST", "/EditarServicos", catch_response=True, data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                print("EditarServicos Response " + str(response) + " with Success " + str(response.text))
        else:
            response.failure("Erro")

    @task(5)
    def editarHorario(self):
        packet_data = "{'horario':['1:12','1:13','1:14','1:16','1:17','2:12','2:13','2:14','2:16','2:17','3:12','3:13','3:14','3:16','3:17','4:12','4:13','5:12','5:13','6:12','6:13','7:12','7:13']}"
        response = self.client.request("POST", "/EditarHorario", catch_response=True, data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                print("EditarHorario Response " + str(response) + " with Success " + str(response.text))
        else:
            response.failure("Erro")

    @task(0)
    def editarTipos(self):
        packet_data = "{'tipos':['1','2','3','4']}"
        response = self.client.request("POST", "/EditarTiposAnimais", catch_response=True, data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                response.success()
                print("EditarTipos Response " + str(response) + " with Success " + str(response.text))
        else:
            response.failure("Erro")

    @task(5)
    def logout(self):
        response = self.client.request("GET", "/Logout", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                self.token = ""
                print("Logout Response " + str(response) + " with Success " + str(response.text))
                self.interrupt()
        else:
            response.failure("Erro")

    @task(1)
    def cancelarPedido(self):
        if len(self.pedidos) > 0:
            idpedido = self.pedidos.pop()["id"]
            packet_data = "{'idPedido':'" + str(idpedido) + "'}"
            response = self.client.request("POST", "/CancelarPedido", data=packet_data, catch_response=True, headers={"Content-Type": "application/x-www-form-urlencoded","Token": self.token})
            if response.status_code == 200:
                response.success()
                dict_response = json.loads(response.text)
                if "success" in dict_response and dict_response["success"] == True:
                    print("CancelarPedido Response " + str(response) + " with Success " + str(response.text))
            else:
                response.failure("Erro")
        else:
            print("Sem pedidos para cancelar")


class IndexBehavior(TaskSet):
    tasks = {DonoBehavior: 40, PetsitterBehavior: 40}
    token = ""
    email = ""
    tipo = ""

    def on_start(self):
        rand = random.randint(0, 2000)
        if 0 <= rand < 1000:
            if len(DONO_CREDENTIALS) > 0:
                self.email = DONO_CREDENTIALS.pop()
        elif 1000 <= rand < 2000:
            if len(PETSITTER_CREDENTIALS) > 0:
                self.email = PETSITTER_CREDENTIALS.pop()
        elif rand == 2000:
            self.email = 'admin1@email.com'
            self.inativarUtilizador(self.email)

    @task(5)
    def index(self):
        response = self.client.request("GET", "/Index", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response:
                print("Index Response " + str(response) + " with Sucess " + str(dict_response["success"]))
        else:
            response.failure("Erro")

    @task(40)
    def login(self):
        packet_data = "{'email':'" + self.email + "', 'password':'ola'}"
        response = self.client.request("POST", "/Autenticar", data=packet_data, catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded"})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                self.token = dict_response["token"]
                self.tipo = dict_response["tipo"]
                print("Login with Email " + self.email + " with Token " + str(self.token) + " with Tipo " + dict_response[
                    "tipo"])
        else:
            print("Failed Login")
            response.failure("Erro")

    #@task(20)
    def registarDono(self):
        packet_data = "{'email':'" + self.email + "','nome':'Nestor','contacto':'112','jardim':'true','morada':'Rua X','password':'ola','avatar':'','concelho':'Porto','distrito':'Porto','dataNasc':'20/03/1999'}"
        response = self.client.request("POST", "/RegistarDono", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded"})
        print("ID" + self.email + "RegistarDono Response: " + str(response) + " with Success " + str(response.text))
        self.wait()

    #@task(20)
    def registarPetsitter(self):
        packet_data = "{'email':'" + self.email + "','nome':'Jose','contacto':'112','jardim':'true','morada':'Rua X','password':'ola','avatar':'','concelho':'Porto','distrito':'Porto','dataNasc':'20/03/1999'}"
        response = self.client.request("POST", "/RegistarPetsitter", data=packet_data,
                                       headers={"Content-Type": "application/x-www-form-urlencoded"})
        print("ID" + self.email + "RegistarPetsitter Response: " + str(response) + " with Success " + str(response.text))
        self.wait()

    def inativarUtilizador(self,email):
        packet_data = "{'email':'" + email + "', 'password':'ola', 'emailDono':'dono999@email.com'}"
        response = self.client.request("POST", "/InativarUtilizador", data=packet_data, catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        if response.status_code == 200:
            response.success()
            dict_response = json.loads(response.text)
            if "success" in dict_response and dict_response["success"] == True:
                print("InativarUtilizador Response " + str(response) + " with Success " + str(response.text))
                response.success()
            else:
                response.failure("Erro")



class WebsiteUser(HttpLocust):
    task_set = IndexBehavior
    min_wait = 3000
    max_wait = 5000
    host = "http://localhost:8088/trustpet_war_exploded.war"

    def __init__(self):
        super(WebsiteUser, self).__init__()
        global PETSITTER_CREDENTIALS, DONO_CREDENTIALS
