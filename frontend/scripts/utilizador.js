Vue.component('side', {
    template: `
<div class="d-none d-sm-block" id="side">
    <img src="../img/logo.png" class="mt-5 mx-auto d-block" width="250" id="logo" />
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
        tiposAnimal: [
            { 'id': '1', 'tipo': 'Gato', 'img': 'img/gato.png' },
            { 'id': '2', 'tipo': 'Cão', 'img': 'img/cao.png' },
            { 'id': '3', 'tipo': 'Pássaro', 'img': 'img/passaro.png' },
            { 'id': '4', 'tipo': 'Tartaruga', 'img': 'img/tartaruga.png' },
            { 'id': '5', 'tipo': 'Peixe', 'img': 'img/peixe.png' },
            { 'id': '6', 'tipo': 'Porco', 'img': 'img/porco.png' },
            { 'id': '7', 'tipo': 'Coelho', 'img': 'img/coelho.png' },
            { 'id': '8', 'tipo': 'Roedor', 'img': 'img/roedor.png' },
            { 'id': '9', 'tipo': 'Réptil', 'img': 'img/reptil.png' }],
        listaServicos: [
            { 'id': '1', 'designacao': 'Petsitting em casa do petsitter' },
            { 'id': '2', 'designacao': 'Petsitting em casa do dono' },
            { 'id': '3', 'designacao': 'Passear' },
            { 'id': '4', 'designacao': 'Alimentar' },
            { 'id': '5', 'designacao': 'Dar banho' },
            { 'id': '6', 'designacao': 'Limpeza do ambiente animal' },
            { 'id': '7', 'designacao': 'Tosquiar' },
            { 'id': '8', 'designacao': 'Entreter' }],
        tipo: "",
        utilizador: {},
        animais: [],
        tiposAnimaisSelecionados: [],
        preco1: "",
        preco2: "",
        preco3: "",
        preco4: "",
        preco5: "",
        preco6: "",
        preco7: "",
        preco8: "",
        horario: []
    },
    mounted: function () {
        if (localStorage.sucesso == "login") {
            this.snackbar("Login efetuado com sucesso.")
            localStorage.sucesso = "";
        }
        else if (localStorage.sucesso == "registo") {
            this.snackbar("Registo efetuado com sucesso.")
            localStorage.sucesso = "";
        }
        else if (localStorage.sucesso == "editar") {
            this.snackbar("Dados editados com sucesso.")
            localStorage.sucesso = "";
        }
        else if (localStorage.sucesso == "pedido") {
            this.snackbar("Pedido efetuado com sucesso.")
            localStorage.sucesso = "";
        }
        else if (localStorage.sucesso == "erro") {
            this.snackbar("Ocorreu um erro. Tente novamente.")
            localStorage.sucesso = "";
        }
        else if (localStorage.sucesso == "remover") {
            this.snackbar("Animal removido com sucesso.")
            localStorage.sucesso = "";
        }
        else if (localStorage.sucesso == "review") {
            this.snackbar("Avaliação efetuada com sucesso.")
            localStorage.sucesso = "";
        }
    },
    methods: {
        registoPetsitter: async function () {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/RegistarPetsitter", {
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
                window.location.replace("http://localhost/registoTiposAnimais.html")
            }
            else {
                localStorage.sucesso = "erro";
            }
        },
        registoTiposAnimais: async function () {
            if (this.tiposAnimaisSelecionados.length == 0) {
                this.snackbar("É necessário selecionar pelo menos um tipo de animal.")
            }
            else {
                const response = await fetch("http://localhost:8080/trustpet_war_exploded/EditarTiposAnimais", {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8',
                        'Token': localStorage.token
                    },
                    method: "POST",
                    body: JSON.stringify({
                        tipos: this.tiposAnimaisSelecionados
                    })
                })
                const content = await response.json()
                if (content.success) {
                    window.location.replace("http://localhost/registoServicos.html")
                }
                else {
                    localStorage.sucesso = "erro";
                }
            }
        },
        registoServicos: async function () {
            var servicosSelecionados = []
            var s = ""
            if (this.preco1 != '') {
                s = '1:' + this.preco1
                servicosSelecionados.push(s)
            }
            if (this.preco2 != '') {
                s = '2:' + this.preco2
                servicosSelecionados.push(s)
            }
            if (this.preco3 != '') {
                s = '3:' + this.preco3
                servicosSelecionados.push(s)
            }
            if (this.preco4 != '') {
                s = '4:' + this.preco4
                servicosSelecionados.push(s)
            }
            if (this.preco5 != '') {
                var s = '5:' + this.preco5
                servicosSelecionados.push(s)
            }
            if (this.preco6 != '') {
                s = '6:' + this.preco6
                servicosSelecionados.push(s)
            }
            if (this.preco7 != '') {
                s = '7:' + this.preco7
                servicosSelecionados.push(s)
            }
            if (this.preco8 != '') {
                s = '8:' + this.preco8
                servicosSelecionados.push(s)
            }
            if (servicosSelecionados.length == 0) {
                this.snackbar("Preencha pelo menos um serviço.")
            }
            else {
                const response = await fetch("http://localhost:8080/trustpet_war_exploded/EditarServicos", {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8',
                        'Token': localStorage.token
                    },
                    method: "POST",
                    body: JSON.stringify({
                        servicos: servicosSelecionados
                    })
                })
                const content = await response.json()
                if (content.success) {
                    window.location.replace("http://localhost/registoHorario.html")
                }
                else {
                    localStorage.sucesso = "erro";
                }
            }
        },
        registoHorario: async function () {
            if (this.horario.length == 0) {
                this.snackbar("Selecione pelo menos uma hora.")
            }
            else {
                const response = await fetch("http://localhost:8080/trustpet_war_exploded/EditarHorario", {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8',
                        'Token': localStorage.token
                    },
                    method: "POST",
                    body: JSON.stringify({
                        horario: this.horario
                    })
                })
                const content = await response.json()
                console.log(JSON.stringify(content))
                if (content.success) {
                    localStorage.sucesso = "registo";
                    window.location.replace("http://localhost/indexPetsitter.html")
                }
                else {
                    localStorage.sucesso = "erro";
                }
            }
        },
        login: async function () {
            if (this.email === '' || this.password === '') {
                this.snackbar("Introduza um e-mail e uma password.")
            }
            else {
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
                    localStorage.sucesso = "login"
                    if (content.tipo == "dono") {
                        window.location.replace("http://localhost/indexDono.html")
                    } else if (content.tipo == "petsitter") {
                        window.location.replace("http://localhost/indexPetsitter.html")
                    }
                }
                else {
                    localStorage.sucesso = "erro"
                    window.location.replace("http://localhost/login.html")
                }
            }
        },
        snackbar: function (content) {
            // Get the snackbar DIV
            var x = document.getElementById("snackbar");

            // Change content
            x.textContent = content

            // Add the "show" class to DIV
            x.className = "show";

            // After 3 seconds, remove the show class from DIV
            setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
        },
        registoDono: async function () {
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
                localStorage.sucesso = "registo"
                window.location.replace("http://localhost/adicionarAnimal.html")
            }
            else {
                localStorage.sucesso = "erro"
            }
        },
        criarUtilizador: function () {
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
        },
        registo: function () {
            if (this.tipo == "dono") {
                window.location.replace("http://localhost/registoPerfilDono.html")
            } else if (this.tipo == "petsitter") {
                window.location.replace("http://localhost/registoPerfilPetsitter.html")
            }
        }
    }
})