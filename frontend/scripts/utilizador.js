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
        animal: {},
        animais: []
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

            if (content.success) {
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
                body: JSON.stringify(this.utilizador)
            })
            const content = await response.json()

            if (content.success) {
                localStorage.token = content.token
                this.token = content.token
                window.location.replace("http://localhost/adicionarAnimal.html")
            }
            else {
                window.location.replace("http://localhost/registoPerfilDono.html")
            }
        },
        criarUtilizador: async function () {
            let jard = "false"
            if (this.jardim)
                jard = "true"
            let date = new Date(this.dataNasc)
            let newDate = date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear()
            this.utilizador = {
                email: this.email,
                password: this.password,
                nome: this.nome,
                avatar: this.avatar,
                dataNasc: newDate,
                contacto: this.contacto,
                jardim: jard,
                morada: this.morada,
                concelho: this.concelho,
                distrito: this.distrito
            }
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
        registoAnimal: async function () {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/EditarAnimal", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "POST",
                body: JSON.stringify(this.animal)
            })
            const content = await response.json()
            if (content.success) {
                window.location.replace("http://localhost/adicionarAnimal.html")
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
            this.animal = {
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
                tipo: this.tipo
            }
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

            this.animais.push(this.animal)
        }
    }
})