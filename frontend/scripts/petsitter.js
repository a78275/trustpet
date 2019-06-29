Vue.component('sidebarpetsitter', {
    methods: {
        logout: function () {
            localStorage.token = ""
            window.location.replace("http://localhost/")
        }
    },
    template: `
<nav id="sidebar">
    <div class="sidebar-header">
        <a href="indexPetsitter.html"><img src="../img/logo.png" width="200" /></a>
    </div>
    <ul class="list-unstyled components">
        <li>
            <a href="">Pedidos Pendentes</a>
        </li>
        <li>
            <a href="#dadosSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Dados
                Pessoais</a>
            <ul class="collapse list-unstyled" id="dadosSubmenu">
                <li>
                    <a href="perfilPetsitter.html">Consultar Perfil</a>
                </li>
                <li>
                    <a href="editarDadosPetsitter.html">Editar Dados Pessoais</a>
                </li>
                <li>
                    <a href="editarTiposAnimais.html">Editar Tipos Animais</a>
                </li>
                <li>
                    <a href="editarServicos.html">Editar Serviços Fornecidos</a>
                </li>
                <li>
                    <a href="editarHorario.html">Editar Horário</a>
                </li>
            </ul>
        </li>
        <li class="sec2">
            <a href="#">Notificações</a>
        </li>
        <li class="sec2">
            <a href="#">Chat</a>
        </li>
        <li class="sec3">
            <a v-on:click="logout()">Logout</a>
        </li>
    </ul>
</nav>
`
})

var vm = new Vue({
    el: "#petsitter",
    data: {
        email: "",
        password: "",
        dataNasc: "",
        contacto: "",
        morada: "",
        jardim: "",
        distrito: "",
        concelho: "",
        nome: "",
        avatar: "",
        utilizador: {},
        perfil: {},
        tiposAnimais: [],
        servicos: [],
        horario: {},
        reviews: [],
        listaServicos: [{ 'id': '1', 'designacao': 'tomar conta' }, { 'id': '2', 'designacao': 'levar a rua' }, { 'id': '3', 'designacao': 'alimentar' }, { 'id': '4', 'designacao': 'dar banho' }],
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
        tiposAnimaisSelecionados: [],
        servicos: [],
        preco1: "",
        preco2: "",
        preco3: "",
        preco4: "",
        horario: [],
        novoHorario: []
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
    created: async function () {
        if (localStorage.token) {
            //Validar
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/Index", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "GET"
            })
            const content = await response.json()
            if (content.email) {

                //Fetch do petsitter
                const responsePetsitter = await fetch("http://localhost:8080/trustpet_war_exploded/ConsultarPerfil", {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8',
                        'Token': localStorage.token
                    },
                    method: 'GET'
                })
                const contentPetsitter = await responsePetsitter.json()
                if (contentPetsitter.success) {
                    this.perfil = contentPetsitter.utilizador
                    this.servicos = contentPetsitter.servicos
                    this.tiposAnimais = this.perfil.animais
                    this.reviews = contentPetsitter.reviews
                    this.horario = this.perfil.horario
                }
                if (window.location.href == "http://localhost/editarDadosPetsitter.html") {
                    let date = this.perfil.dataNasc.split("/")
                    let newDate = + date[2] + "-" + date[1] + "-" + date[0]
                    this.nome = this.perfil.nome
                    this.email = this.perfil.email
                    this.password = ""
                    this.dataNasc = newDate
                    this.contacto = this.perfil.contacto
                    this.avatar = this.perfil.avatar
                    this.morada = this.perfil.morada
                    this.distrito = this.perfil.distrito
                    this.concelho = this.perfil.concelho
                    this.jardim = this.perfil.jardim
                }
                if (window.location.href == "http://localhost/editarTiposAnimais.html") {
                    for (t of this.tiposAnimais) {
                        this.tiposAnimaisSelecionados.push(t.id)
                    }
                }
                if (window.location.href == "http://localhost/editarServicos.html") {
                    for (s of this.servicos) {
                        var found = this.listaServicos.find(function (element) {
                            return element.designacao == s.servico
                        })
                        if (found.id == '1')
                            this.preco1 = s.preco
                        if (found.id == '2')
                            this.preco2 = s.preco
                        if (found.id == '3')
                            this.preco3 = s.preco
                        if (found.id == '4')
                            this.preco4 = s.preco
                    }
                }
                if (window.location.href == "http://localhost/editarHorario.html") {
                    for (d of this.horario.dias) {
                        var str = d.dia + ':'
                        for (h of d.horas) {
                            var val = str + h.hora
                            this.novoHorario.push(val)
                        }
                    }
                }
                /*
                //Fetch dos pedidos

                const responsePedidos = await fetch("http://localhost:8080/trustpet_war_exploded/ConsultarPedidos", {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8',
                        'Token': localStorage.token
                    },
                    method: 'GET'
                })
                const contentPedidos = await responsePedidos.json()
                if (contentPedidos.success) {
                    this.pedidosPendentes = contentPedidos.pedidos
                }*/
            }
        }
    },
    methods: {
        getTipo: function (id) {
            var found = this.tiposAnimal.find(function (element) {
                return element.id == id
            })
            return found
        },
        temHora: function (dia, hora) {
            var found = this.horario.dias.find(function (element) {
                return element.dia == dia
            })
            var founded = found.horas.find(function (element) {
                return element.hora == hora
            })

            if (founded != undefined)
                return true
            else
                return false
        },
        editarDadosPetsitter: async function () {
            console.log('olá')
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/EditarDadosPessoais", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "POST",
                body: JSON.stringify(this.utilizador)
            })
            const content = await response.json()

            if (content.success) {
                localStorage.sucesso = "editar";
                window.location.replace("http://localhost/perfilPetsitter.html");
            }
            else {
                localStorage.sucesso = "erro";
                window.location.replace("http://localhost/editarDadosPetsitter.html");
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
        camposObrigatorios: async function () {
            // Get the snackbar DIV
            var x = document.getElementById("snackbar");

            // Change content
            x.textContent = "É necessário preencher todos os campos obrigatórios."

            // Add the "show" class to DIV
            x.className = "show";

            // After 3 seconds, remove the show class from DIV
            setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
        },
        editarTiposAnimais: async function () {
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
                    localStorage.sucesso == "editar";
                    window.location.replace("http://localhost/perfilPetsitter.html")
                }
                else {
                    localStorage.sucesso == "erro";
                    window.location.replace("http://localhost/editarTiposAnimais.html")
                }
            }
        },
        editarServicos: async function () {
            var servicosSelecionados = []
            if (this.preco1 != '') {
                var s = '1:' + this.preco1
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
                console.log(JSON.stringify(content))
                if (content.success) {
                    localStorage.sucesso == "editar";
                    window.location.replace("http://localhost/perfilPetsitter.html")
                }
                else {
                    localStorage.sucesso == "erro";
                    window.location.replace("http://localhost/editarServicos.html")
                }
            }
        },
        editarHorario: async function () {
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
                        horario: this.novoHorario
                    })
                })
                const content = await response.json()
                console.log(JSON.stringify(content))
                if (content.success) {
                    localStorage.sucesso == "editar";
                    window.location.replace("http://localhost/perfilPetsitter.html")
                }
                else {
                    localStorage.sucesso == "erro";
                    window.location.replace("http://localhost/editarHorario.html")
                }
            }
        }
    }
})