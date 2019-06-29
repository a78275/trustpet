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
                    <a href="#">Editar Serviços Fornecidos</a>
                </li>
                <li>
                    <a href="#">Editar Tipos Animais</a>
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
        tiposAnimal: [{ 'id': '1', 'tipo': 'Gato', 'img': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSf5fBKv_d93io82eZokxqn_4jsHFSolEpiqeNPxjxy12DIiM0T' }, { 'id': '2', 'tipo': 'Cão', 'img': 'https://essencecuidados.com.br/wp-content/uploads/2016/10/dog.jpg' }, { 'id': '3', 'tipo': 'Pássaro', 'img': 'https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/04/10/19/pinyon-jay-bird.jpg' }, { 'id': '4', 'tipo': 'Tartaruga', 'img': 'https://oliveridleyproject.org/wp-content/uploads/2018/05/Olive-ridley-turtle-baby-patient-Luna-recovering-rescue-centre-ORP.jpg' }]
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
                /*
                //Fetch dos animais
                const responseAnimal = await fetch("http://localhost:8080/trustpet_war_exploded/ConsultarAnimais", {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8',
                        'Token': localStorage.token
                    },
                    method: 'GET'
                })
                const contentAnimal = await responseAnimal.json()
                if (contentAnimal.success) {
                    this.animais = JSON.parse(contentAnimal.animais)
                }



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
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/EditarDadosPessoais", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8'
                },
                method: "POST",
                body: JSON.stringify(this.utilizador)
            })
            const content = await response.json()

            if (content.success) {
                window.location.replace("http://localhost/editarDadosPetsitter.html")
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
        }
    }
})