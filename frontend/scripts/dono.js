Vue.component('sidebardono', {
    template: `
<nav id="sidebar">
    <div class="sidebar-header">
        <a href="indexDono.html"><img src="../img/logo.png" width="200" /></a>
    </div>
    <ul class="list-unstyled components">
        <li>
            <a href="pedidosPendentes.html">Pedidos Pendentes</a>
        </li>
        <li>
            <a href="consultarPetsitters.html">Consultar Petsitters</a>
        </li>
        <li>
            <a href="selAnimaisData.html">Efetuar Pedido</a>
        </li>
        <li>
            <a href="#dadosSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Dados
                Pessoais</a>
            <ul class="collapse list-unstyled" id="dadosSubmenu">
                <li>
                    <a href="perfilDono.html">Consultar Perfil</a>
                </li>
                <li>
                    <a href="editarDadosDono.html">Editar Dados Pessoais</a>
                </li>
                <li>
                    <a href="#">Editar Dados dos Animais</a>
                </li>
                <li>
                    <a href="adicionarAnimal.html">Adicionar Animal</a>
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
            <a v-on:click="">Logout</a>
        </li>
    </ul>
</nav>
`
})

var vm = new Vue({
    el: "#dono",
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
        tipo: "",
        idades: ['Bebé', 'Jovem', 'Adulto', 'Sénior'],
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
        animal: {},
        animais: [],
        servicos: [{
            'id': '1',
            'servicos': {
                '1': 'Passear',
                '2': 'Dar banho'
            }
        }, {
            'id': '2',
            'servicos': {
                '1': 'Passear',
                '4': 'Alimentar',
                '5': 'Coçar as costas',
                '6': 'Escovar o pêlo',
                '7': 'Brincar'
            }
        }],
        tiposAnimal: [{ 'id': '1', 'tipo': 'Gato', 'img': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSf5fBKv_d93io82eZokxqn_4jsHFSolEpiqeNPxjxy12DIiM0T' }, { 'id': '2', 'tipo': 'Cão', 'img': 'https://essencecuidados.com.br/wp-content/uploads/2016/10/dog.jpg' }, { 'id': '3', 'tipo': 'Pássaro', 'img': 'https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/04/10/19/pinyon-jay-bird.jpg' }, { 'id': '4', 'tipo': 'Tartaruga', 'img': 'https://oliveridleyproject.org/wp-content/uploads/2018/05/Olive-ridley-turtle-baby-patient-Luna-recovering-rescue-centre-ORP.jpg' }],
        petsitters: [],
        pedidosPendentes: [],
        dataInicio: "",
        dataFim: "",
        horaInicio: "",
        horaFim: "",
        perfil: {},
        animaisSelecionados: [],
        listaServicos: [],
        servicosAnimaisSelecionados: [],
        petsitter: {},
        comentario: "",
        pontuacao: 0,
        reviews: [],
        utilizador: {}
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

                //Fetch do dono
                const responseDono = await fetch("http://localhost:8080/trustpet_war_exploded/ConsultarPerfil", {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8',
                        'Token': localStorage.token
                    },
                    method: 'GET'
                })
                const contentDono = await responseDono.json()
                if (contentDono.success) {
                    this.perfil = contentDono.utilizador
                    this.reviews = contentDono.reviews
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
                }

                if (window.location.href == "http://localhost/consultarPetsitters.html") {
                    //Fetch dos petsitters
                    const responsePetsitters = await fetch("http://localhost:8080/trustpet_war_exploded/ConsultarPetsitters", {
                        headers: {
                            'Content-Type': 'application/json; charset=utf-8',
                            'Token': localStorage.token
                        },
                        method: 'GET'
                    })
                    const contentPetsitters = await responsePetsitters.json()
                    if (contentPetsitters.success) {
                        this.petsitters = contentPetsitters.petsitters
                    }
                }
                if (window.location.href == "http://localhost/selServicos.html") {
                    this.listaServicos = JSON.parse(localStorage.servicos)
                    this.dataInicio = localStorage.dataInicio
                    this.dataFim = localStorage.dataFim
                }
                if (window.location.href == "http://localhost/selPetsitter.html") {
                    this.petsitters = JSON.parse(localStorage.petsitters)
                }
                if (window.location.href == "http://localhost/editarDadosDono.html") {
                    let date = this.perfil.dataNasc.split("/")
                    let newDate = + date[2] + "-" + date[1] + "-" + date[0]
                    this.nome = this.perfil.nome
                    this.email = this.perfil.email
                    this.password = this.perfil.password
                    this.dataNasc = newDate
                    this.contacto = this.perfil.contacto
                    this.avatar = this.perfil.avatar
                    this.morada = this.perfil.morada
                    this.distrito = this.perfil.distrito
                    this.concelho = this.perfil.concelho
                    this.jardim = this.perfil.jardim
                }
            } else {
                window.location.replace("http://localhost/index.html")
            }
        } else {
            window.location.replace("http://localhost/index.html")
        }
    },
    methods: {
        registarPedido: async function () {
            let dateInicio = new Date(this.dataInicio)
            let newDataInicio = dateInicio.getDate() + "/" + (dateInicio.getMonth() + 1) + "/" + dateInicio.getFullYear()
            let dateFim = new Date(this.dataFim)
            let newDataFim = dateFim.getDate() + "/" + (dateFim.getMonth() + 1) + "/" + dateFim.getFullYear()
            localStorage.dataInicio = newDataInicio + ' ' + this.horaInicio
            localStorage.dataFim = newDataFim + ' ' + this.horaFim
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/RegistarPedido", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "POST",
                body: JSON.stringify({
                    dataInicio: newDataInicio + ' ' + this.horaInicio,
                    dataFim: newDataFim + ' ' + this.horaFim,
                    animais: this.animaisSelecionados
                })
            })
            const content = await response.json()
            if (content.success) {
                localStorage.idPedido = content.idPedido
                localStorage.servicos = JSON.stringify(content.servicos)
                window.location.replace("http://localhost/selServicos.html")
            }
        },
        selServicos: async function () {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/SelServicos", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "POST",
                body: JSON.stringify({
                    animalServicos: this.servicosAnimaisSelecionados,
                    idPedido: localStorage.idPedido
                })
            })
            const content = await response.json()
            if (content.success) {
                localStorage.petsitters = JSON.stringify(content.petsitters)
                window.location.replace("http://localhost/selPetsitter.html")
            }
        },
        logout: function () {
            localStorage.token = ""
        },
        avaliar: async function (id) {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/AvaliarUtilizador", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "POST",
                body: JSON.stringify({
                    emailAlvo: id,
                    comentario: this.comentario,
                    avaliacao: this.pontuacao
                })
            })
            const content = await response.json()
            if (content.success) {
                console.log("review feita com sucesso!")
            }
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
                window.location.replace("http://localhost/adicionarAnimal.html")
            }
            else {
                // Get the snackbar DIV
                var x = document.getElementById("snackbar");

                // Change content
                x.textContent = "Ocorreu um erro ao efetuar o registo."

                // Add the "show" class to DIV
                x.className = "show";

                // After 3 seconds, remove the show class from DIV
                setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
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