Vue.component('form-perfil', {
    template: `
<div id="userRegister">
    <form class="mx-5 my-5">
        <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" id="nome" v-model="nome"
                placeholder="Introduza o seu nome" required>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="email">E-mail</label>
                <input type="email" class="form-control" id="email" v-model="email"
                    placeholder="Introduza o seu endereço de e-mail" required>
            </div>
            <div class="form-group col-md-6">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" v-model="password"
                    placeholder="Introduza uma palavra-passe" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="datanascimento">Data de nascimento</label>
                <input type="date" class="form-control" id="datanascimento" v-model="dataNasc"
                    placeholder="Introduza a sua data de nascimento" required>
            </div>
            <div class="form-group col-md-6">
                <label for="contacto">Contacto</label>
                <input type="text" class="form-control" id="contacto" v-model="contacto"
                    placeholder="Introduza o seu número de telemóvel" required>
            </div>
        </div>
        <div class="form-group">
            <label for="morada">Morada</label>
            <input type="text" class="form-control" id="morada" v-model="morada"
                placeholder="Introduza a sua morada e número da porta" required>
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="jardim"
                    v-model="jardim">
                <label class="form-check-label" for="jardim">
                    Tem Jardim?
                </label>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="distrito">Distrito</label>
                <input type="text" class="form-control" id="distrito" v-model="distrito"
                    placeholder="Introduza o seu distrito" required>
            </div>
            <div class="form-group col-md-6">
                <label for="concelho">Concelho</label>
                <input type="text" class="form-control" id="concelho" v-model="concelho"
                    placeholder="Introduza o seu concelho" required>
            </div>
        </div>
        <div class="form-group">
            <label for="pic">Fotografia</label>
            <input type="text" class="form-control" id="pic" v-model="avatar"
                placeholder="Introduza o url da fotografia" required>
        </div>
    </form>
</div>
`
})

Vue.component('side', {
    template: `
<div class="d-none d-sm-block" id="side">
    <a href="index.html"><img src="../img/logo.png" class="mt-5 mx-auto d-block" width="250" id="logo" /></a>
</div>
`
})

var vm = new Vue({
    el: "#utilizador",
    data: {
        email: "",
        password: "",
        nome: "",
        dataNasc: "",
        contacto: "",
        morada: "",
        jardim: "",
        distrito: "",
        concelho: "",
        avatar: "",
        tiposAnimal: [{ 'id': '1', 'tipo': 'Gato' }, { 'id': '2', 'tipo': 'Cão' }, { 'id': '3', 'tipo': 'Pássaro' }, { 'id': '4', 'tipo': 'Tartaruga' }],
        tipo: "",
        idade: "",
        raca: "",
        sexo: "",
        porte: "",
        alergias: "",
        doencas: "",
        comportamento: "",
        vacinas: "",
        desparasitacao: "",
        esterilizacao: "",
        utilizador: {},
        animais: []
    },
    created: async function () {
        if (localStorage.token) {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/Index", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "GET"
            })
            const content = await response.json()
            if (content.email) {
                if (content.tipo == 'dono') {
                    window.location.replace("http://localhost/indexDono.html")
                } else if (content.tipo == 'petsitter') {
                    window.location.replace("http://localhost/indexPetsitter.html")
                }
            }
        }
    },
    methods: {
        login: async function () {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/Autenticar", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8'
                },
                method: "POST",
                body: JSON.stringify({
                    email: this.email,
                    password: this.password
                })
            })
            const content = await response.json()

            if (content.sucess) {
                localStorage.token = content.token
                this.token = content.token
                if (content.tipo == "dono") {
                    window.location.replace("http://localhost/indexDono.html")
                } else if (content.tipo == "petsitter") {
                    window.location.replace("http://localhost/indexPetsitter.html")
                }
            }
        },
        registoDono: async function () {
            let date = new Date(this.dataNasc)
            let newDate = date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear()
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/RegistarDono", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8'
                },
                method: "POST",
                body: this.utilizador
            })
            await registoAnimais()
            const content = await response.json()
        },
        criarUtilizador: async function () {
            let date = new Date(this.dataNasc)
            let newDate = date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear()
            this.utilizador = JSON.stringify({
                email: this.email,
                password: this.password,
                nome: this.nome,
                avatar: this.avatar,
                dataNasc: newDate,
                contacto: this.contacto,
                jardim: this.jardim,
                morada: this.morada,
                concelho: this.concelho,
                distrito: this.distrito
            })
            this.email = ""
            this.password = ""
            this.nome = ""
            this.dataNasc = ""
            this.contacto = ""
            this.morada = ""
            this.jardim = ""
            this.distrito = ""
            this.concelho = ""
            this.avatar = ""
        },
        registoPetsitter: async function () {

        },
        registoAnimais: async function () {
            for (var i = 0; i < this.animais.length; i++) {
                const response = await fetch("http://localhost:8080/trustpet_war_exploded/EditarAnimal", {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    method: "POST",
                    body: this.animais[i]
                })
                const content = await response.json()
                if (!content.sucess) {
                    i--
                }
                console.log(JSON.stringify(content))
            }
        },
        criarAnimal: async function () {
            let vac = "false"
            if (this.vacinas != "")
                vac = "true"
            let desp = "false"
            if (this.desparasitacao != "")
                desp = "true"
            let est = "false"
            if (this.esterilizacao != "")
                est = "true"
            let animal = JSON.stringify({
                nome: this.nome,
                avatar: this.avatar,
                idade: this.idade,
                porte: this.porte,
                sexo: this.sexo,
                alergias: this.alergias,
                doencas: this.doencas,
                comportamento: this.comportamento,
                vacinas: vac,
                desparasitacao: desp,
                esterilizacao: est,
                raca: this.raca,
                tipo: this.tipo,
                emailDono: 'joanacmp.97@gmail.com'
            })
            this.nome = ""
            this.avatar = ""
            this.idade = ""
            this.porte = ""
            this.sexo = ""
            this.alergias = ""
            this.doencas = ""
            this.comportamento = ""
            this.vacinas = ""
            this.desparasitacao = ""
            this.esterilizacao = ""
            this.tipo = ""
            this.raca = ""

            this.animais.push(animal)
        }
    }
})