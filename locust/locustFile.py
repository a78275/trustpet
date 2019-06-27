import random
import json
from locust import HttpLocust, TaskSet, task
from credentials import DONO_CREDENTIALS, PETSITTER_CREDENTIALS


class DonoBehavior(TaskSet):
    token = ""

    def on_start(self):
        if self.parent.token is None or self.parent.token == "":
            self.interrupt()
            print("Não tem login feito")
        else:
            self.token = self.parent.token

    def on_stop(self):
        """ on_stop is called when the TaskSet is stopping """
        pass

    @task(1)
    def logout(self):
        response = self.client.request("POST", "/Logout", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("Logout Response " + str(response) + " with Success " + str(response.text))
        self.token = ""
        self.interrupt()

    @task(10)
    def consultarAnimais(self):
        response = self.client.request("GET", "/ConsultarAnimais", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("ConsultarAnimais Response " + str(response) + " with Animals " + str(response.text))


class IndexBehavior(TaskSet):
    #tasks = {DonoBehavior:5}
    token = ""
    email = ""

    def on_start(self):
        if bool(random.getrandbits(1)) :
            if len(PETSITTER_CREDENTIALS) > 0:
                self.email = PETSITTER_CREDENTIALS.pop()
        else:
            if len(DONO_CREDENTIALS) > 0:
                self.email = DONO_CREDENTIALS.pop()

    #@task(10)
    def index(self):
        response = self.client.request("GET", "/Index", catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded",
                                                "Token": self.token})
        print("Index Response " + str(response) + " with Tipo " + str(response.text))

    @task(5)
    def login(self):
        packet_data = "{'email':'" + self.email + "', 'password':'ola'}"
        response = self.client.request("POST", "/Autenticar", data=packet_data, catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded"})
        token = response.text.split(",")
        if len(token) > 2:
            token = token[2]
            self.token = token[9:29]
            print(response.text)
            print("Login with Email " + self.email + " with Token " + str(self.token))
        else:
            print("Login Response: " + str(token))

    #@task(1)
    def registarDono(self):
        packet_data = "{'email':'" + self.email + "','nome':'Nestor','contacto':'112','jardim':'true','morada':'Rua X','password':'ola','avatar':'','concelho':'Porto','distrito':'Porto','dataNasc':'20/03/1999'}"
        response = self.client.request("POST", "/RegistarDono", data=packet_data, catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded"})
        print("ID" + self.email + "RegistarDono Response: " + str(response) + " with Success " + str(response.text))

    #@task(1)
    def registarPetsitter(self):
        packet_data = "{'email':'" + self.email + "','nome':'Jose','contacto':'112','jardim':'true','morada':'Rua X','password':'ola','avatar':'','concelho':'Porto','distrito':'Porto','dataNasc':'20/03/1999'}"
        response = self.client.request("POST", "/RegistarPetsitter", data=packet_data, catch_response=True,
                                       headers={"Content-Type": "application/x-www-form-urlencoded"})
        print("ID" + self.email + "RegistarPetsitter Response: " + str(response) + " with Success " + str(response.text))


class WebsiteUser(HttpLocust):
    task_set = IndexBehavior
    min_wait = 5000
    max_wait = 10000
    host = "http://localhost:8080/trustpet_war_exploded"

    def __init__(self):
        super(WebsiteUser, self).__init__()
        global PETSITTER_CREDENTIALS_CREDENTIALS, DONO_CREDENTIALS
