Vue.component('sidebardono', {
    methods: {
        logout: async function () {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/Logout", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "GET"
            })
            const content = await response.json()
            if (content.success) {
                localStorage.token = ""
                window.location.replace("http://localhost/")
            }
        }
    },
    template: `
<nav id="sidebar">
    <div class="sidebar-header">
        <a href="indexDono.html"><img src="../img/logo.png" width="200" /></a>
    </div>
    <ul class="list-unstyled components">
        <li>
            <a href="pedidosPendentesDono.html">Pedidos Pendentes</a>
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
                    <a href="editarAnimais.html">Editar Dados dos Animais</a>
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
            <a v-on:click="logout()">Logout</a>
        </li>
    </ul>
</nav>
`
})

Vue.component('avaliar-petsitter', {
    props: ['petsitter'],
    data: () => ({
        comentario: "",
        pontuacao: 0,
        id1: "",
        id2: "",
        id3: "",
        id4: "",
        id5: ""
    }),
    mounted: function () {
        this.id1 = this.$props.petsitter.email + '1'
        this.id2 = this.$props.petsitter.email + '2'
        this.id3 = this.$props.petsitter.email + '3'
        this.id4 = this.$props.petsitter.email + '4'
        this.id5 = this.$props.petsitter.email + '5'
    },
    methods: {
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
                    avaliacao: this.pontuacao + ""
                })
            })
            const content = await response.json()
            if (content.success) {
                localStorage.sucesso = "review";
            }
            else {
                localStorage.sucesso = "erro";
                window.location.replace("http://localhost/avaliarPetsitter.html")
            }
        }
    },
    template: `
<div class="modal fade" tabindex="-1" role="dialog"
    aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" style="color: #545871;"
                    id="exampleModalLongTitle">
                    Avaliar Petsitter - {{ petsitter.email }}
                </h5>
                <button type="button" id="submitRegistoDono" class="close"
                    data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group"
                    style="width: 90%; display: block; margin-left: auto; margin-right: auto;">
                    <div class="form-group shadow-textarea">
                        <textarea class="form-control z-depth-1" rows="3"
                            v-model="comentario"
                            placeholder="Faça um comentário ao petsitter"></textarea>
                    </div>
                </div>
                <div class="row"
                    style="width: 90%; display: block; margin-left: auto; margin-right: auto;">
                    <div class="col-6 blockHead" v-if="pontuacao == ''"><span
                            class="blocktext">Clicar para classificar</span>
                    </div>
                    <div class="col-6 blockHead" v-if="pontuacao == 1"><span
                            class="blocktext">Muito Mau</span>
                    </div>
                    <div class="col-6 blockHead" v-if="pontuacao == '2'"><span
                            class="blocktext">Mau</span>
                    </div>
                    <div class="col-6 blockHead" v-if="pontuacao == '3'"><span
                            class="blocktext">Médio</span>
                    </div>
                    <div class="col-6 blockHead" v-if="pontuacao == '4'"><span
                            class="blocktext">Bom</span>
                    </div>
                    <div class="col-6 blockHead" v-if="pontuacao == '5'"><span
                            class="blocktext">Muito Bom</span>
                    </div>
                    <div class="col-5 rate">
                        <input type="radio" :id="id5" v-model="pontuacao" value="5" />
                        <label :for="id5" title="text">5 stars</label>
                        <input type="radio" :id="id4" v-model="pontuacao" value="4" />
                        <label :for="id4" title="text">4 stars</label>
                        <input type="radio" :id="id3" v-model="pontuacao" value="3" />
                        <label :for="id3" title="text">3 stars</label>
                        <input type="radio" :id="id2" v-model="pontuacao" value="2" />
                        <label :for="id2" title="text">2 stars</label>
                        <input type="radio" :id="id1" v-model="pontuacao" value="1" />
                        <label :for="id1" title="text">1 star</label>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn" id="pinkbtn"
                    style="font-size: 1em; padding-right: 20px; padding-left: 20px;"
                    data-dismiss="modal">Voltar</button>
                <button type="button" v-on:click="avaliar(petsitter.email)"
                    style="font-size: 1em; padding-right: 20px; padding-left: 20px;"
                    id="darkbluebtn">Enviar</button>
            </div>
        </div>
    </div>
</div>
    `
})

Vue.component('card-animal', {
    props: ['animal'],
    template: `
<div>
    <img :src=animal.avatar class="mt-3"
        style="overflow:hidden; width:170px; height:170px; border-radius:50%; display: block; margin-left: auto; margin-right: auto;">
    <h3 class="text-uppercase text-center mt-2">{{ animal.nome }}</h3>
    <p class="text-center">{{ animal.raca }}</p>
    <table class="table table-bordered"
        style="width: 90%; margin-left: auto; margin-right: auto; table-layout: fixed;">
        <tbody style="color: #545871;">
            <tr>
                <td v-if="animal.sexo=='F'" style="text-align: center;">
                    <i class='fas fa-venus' style="font-size:25px;color:#ebd0ce;"></i>
                    <br>Fêmea
                </td>
                <td v-else style="text-align: center;">
                    <i class='fas fa-mars' style="font-size:25px;color:#ebd0ce;"></i>
                    <br>Macho
                </td>

                <td style="text-align: center;">
                    <span
                        style="font-weight:600;font-size:20px;color:#ebd0ce;">{{ animal.idade }}</span>
                    <br>Idade
                </td>

                <td style="text-align: center;">
                    <span
                        style="font-weight:500;font-size:17px;color:#ebd0ce;">{{ animal.porte }}</span>
                    <br>Porte
                </td>
            </tr>
            <tr>
                <td v-if="animal.desparasitacao==true" style="text-align: center;">
                    <i class='fa fa-check' style="font-size:25px;color:#ebd0ce;"></i>
                    <br>Desparasitação
                </td>
                <td v-else style="text-align: center;">
                    <i class='fa fa-times' style="font-size:25px;color:#ebd0ce;"></i>
                    <br>Desparasitação
                </td>

                <td v-if="animal.esterilizacao==true" style="text-align: center;">
                    <i class='fa fa-check' style="font-size:25px;color:#ebd0ce;"></i>
                    <br>Esterilização
                </td>
                <td v-else style="text-align: center;">
                    <i class='fa fa-times' style="font-size:25px;color:#ebd0ce;"></i>
                    <br>Esterilização
                </td>

                <td v-if="animal.vacinas==true" style="text-align: center;">
                    <i class='fa fa-check' style="font-size:25px;color:#ebd0ce;"></i>
                    <br>Vacinação
                </td>
                <td v-else style="text-align: center;">
                    <i class='fa fa-times' style="font-size:25px;color:#ebd0ce;"></i>
                    <br>Vacinação
                </td>
            </tr>
        </tbody>
    </table>
    <div style="width: 90%; margin-left: auto; margin-right: auto;">
        <p v-if="animal.alergias">Alergias: <span
                style="color:#ebd0ce;">{{ animal.alergias }}</span></p>
        <p v-if="animal.doencas">Doenças: <span
                style="color:#ebd0ce;">{{ animal.doencas }}</span></p>
        <p v-if="animal.comportamento">Comportamento: <span
                style="color:#ebd0ce;">{{ animal.comportamento }}</span></p>
    </div>
</div>
    `
})

Vue.component('rm-animal', {
    props: ['animal'],
    methods: {
        removerAnimal: async function (id) {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/EditarAnimal", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8'
                },
                method: "POST",
                body: JSON.stringify({
                    id: id + '',
                    ativo: "false"
                })
            })
            const content = await response.json()

            if (content.success) {
                localStorage.sucesso = "remover";
            }
            else {
                localStorage.sucesso = "erro";
            }
            window.location.replace("http://localhost/editarAnimais.html")
        }
    },
    template: `
<div class="modal fade" tabindex="-1" role="dialog"
    aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" style="color: #545871;"
                    id="exampleModalLongTitle">
                    Remover Animal
                </h5>
                <button type="button" id="submitRegistoDono" class="close"
                    data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Tem a certeza que pretende remover o seguinte animal?
                <img :src=animal.avatar class="mt-3"
                    style="overflow:hidden; width:130px; height:130px; border-radius:50%; display: block; margin-left: auto; margin-right: auto;">
                <h3 class="text-uppercase text-center mt-2">
                    {{ animal.nome }}</h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn" id="pinkbtn"
                    style="font-size: 1em; padding-right: 20px; padding-left: 20px;"
                    data-dismiss="modal">Voltar</button>
                <button type="button" v-on:click="removerAnimal(animal.id)"
                    style="font-size: 1em; padding-right: 20px; padding-left: 20px;"
                    id="bluepinkbtn">Confirmar</button>
            </div>
        </div>
    </div>
</div>
`})

var vm = new Vue({
    el: "#dono",
    data: {
        id: "",
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
        sexo: "M",
        porte: "",
        alergias: "",
        doencas: "",
        comportamento: "",
        vacinas: "",
        desparasitacao: "",
        esterilizacao: "",
        animal: {},
        animais: [],
        servicos: [
            {
                'id': '1',
                'servicos': {
                    '1': 'Petsitting em casa do petsitter',
                    '2': 'Petsitting em casa do dono',
                    '3': 'Passear',
                    '4': 'Alimentar',
                    '5': 'Dar banho',
                    '6': 'Limpeza do ambiente animal',
                    '7': 'Tosquiar',
                    '8': 'Entreter'
                }
            },
            {
                'id': '2',
                'servicos': {
                    '1': 'Petsitting em casa do petsitter',
                    '2': 'Petsitting em casa do dono',
                    '3': 'Passear',
                    '4': 'Alimentar',
                    '5': 'Dar banho',
                    '6': 'Limpeza do ambiente animal',
                    '7': 'Tosquiar',
                    '8': 'Entreter'
                }
            },
            {
                'id': '3',
                'servicos': {
                    '1': 'Petsitting em casa do petsitter',
                    '2': 'Petsitting em casa do dono',
                    '4': 'Alimentar',
                    '6': 'Limpeza do ambiente animal',
                    '8': 'Entreter'
                }
            },
            {
                'id': '4',
                'servicos': {
                    '1': 'Petsitting em casa do petsitter',
                    '2': 'Petsitting em casa do dono',
                    '4': 'Alimentar',
                    '6': 'Limpeza do ambiente animal'
                }
            },
            {
                'id': '5',
                'servicos': {
                    '1': 'Petsitting em casa do petsitter',
                    '2': 'Petsitting em casa do dono',
                    '4': 'Alimentar',
                    '6': 'Limpeza do ambiente animal'
                }
            },
            {
                'id': '6',
                'servicos': {
                    '1': 'Petsitting em casa do petsitter',
                    '2': 'Petsitting em casa do dono',
                    '3': 'Passear',
                    '4': 'Alimentar',
                    '5': 'Dar banho',
                    '6': 'Limpeza do ambiente animal',
                    '8': 'Entreter'
                }
            },
            {
                'id': '7',
                'servicos': {
                    '1': 'Petsitting em casa do petsitter',
                    '2': 'Petsitting em casa do dono',
                    '4': 'Alimentar',
                    '5': 'Dar banho',
                    '6': 'Limpeza do ambiente animal',
                    '8': 'Entreter'
                }
            },
            {
                'id': '8',
                'servicos': {
                    '1': 'Petsitting em casa do petsitter',
                    '2': 'Petsitting em casa do dono',
                    '4': 'Alimentar',
                    '5': 'Dar banho',
                    '6': 'Limpeza do ambiente animal',
                    '8': 'Entreter'
                }
            },
            {
                'id': '9',
                'servicos': {
                    '1': 'Petsitting em casa do petsitter',
                    '2': 'Petsitting em casa do dono',
                    '4': 'Alimentar',
                    '6': 'Limpeza do ambiente animal',
                    '8': 'Entreter'
                }
            }],
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
        reviews: [],
        utilizador: {},
        selDistrito: "Todos",
        selConcelho: "Todos",
        search: "",
        ordenacao: "Descendente",
        servicosPetsitter: [],
        avaliacaoMediaNr: 0
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
        else if (localStorage.sucesso == "cancelar") {
            this.snackbar("Pedido cancelado com sucesso.")
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

                        for (var p of this.petsitters) {
                            var value = parseFloat(String(p.avaliacaoMedia).substring(0, 3));
                            p.avaliacaoMedia = value
                        }
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
                    this.password = ""
                    this.dataNasc = newDate
                    this.contacto = this.perfil.contacto
                    this.avatar = this.perfil.avatar
                    this.morada = this.perfil.morada
                    this.distrito = this.perfil.distrito
                    this.concelho = this.perfil.concelho
                    this.jardim = this.perfil.jardim
                }
                if (window.location.href == "http://localhost/editarAnimal.html") {
                    var animal = this.animais.find(function (element) {
                        return element.id == localStorage.idAnimal
                    })
                    this.nome = animal.nome
                    this.avatar = animal.avatar
                    this.idade = animal.idade
                    this.porte = animal.porte
                    this.sexo = animal.sexo
                    this.alergias = animal.alergias
                    this.doencas = animal.doencas
                    this.comportamento = animal.comportamento
                    this.vacinas = animal.vacinas
                    this.desparasitacao = animal.desparasitacao
                    this.esterilizacao = animal.esterilizacao
                    this.raca = animal.raca
                    this.tipo = animal.tipo.id
                    this.id = localStorage.idAnimal
                }
                if (window.location.href == "http://localhost/consultarPetsitter.html") {
                    const responsePetsitter = await fetch("http://localhost:8080/trustpet_war_exploded/ConsultarPerfil", {
                        headers: {
                            'Content-Type': 'application/json; charset=utf-8',
                            'Token': localStorage.token
                        },
                        method: 'POST',
                        body: JSON.stringify({
                            emailConsulta: localStorage.petsitter
                        })
                    })
                    const contentPetsitter = await responsePetsitter.json()
                    if (contentPetsitter.success) {
                        this.petsitter = contentPetsitter.utilizador
                        this.servicosPetsitter = contentPetsitter.servicos
                        this.petsitter.tiposAnimais = contentPetsitter.utilizador.animais
                        this.petsitter.reviews = contentPetsitter.reviews

                    }
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
            if (this.animaisSelecionados.length == 0) {
                this.snackbar("O pedido deve estar associado a pelo menos um animal.");
            }
            else {
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
            }
        },
        selServicos: async function () {
            var ok = true;
            var animais = [];

            // Ver animais que têm serviços
            for (var animal of this.servicosAnimaisSelecionados) {
                var parts = animal.split(':');
                var idAnimal = parts[0];
                if (!animais.includes(idAnimal))
                    animais.push(Number(idAnimal))
            }
            // Ver se os animais que têm serviços são os que foram selecionados
            for (var animal of JSON.parse(localStorage.servicos)) {
                if (!animais.includes(animal.id)) {
                    ok = false;
                }
            }
            if (!ok) {
                this.snackbar("Selecione pelo menos um serviço para cada animal.")
            }
            else {
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
                else {
                    localStorage.sucesso = "erro";
                    window.location.replace("http://localhost/selServicos.html");
                }
            }
        },
        selPetsitter: async function (email) {
            console.log(email)
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/SelPetsitter", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "POST",
                body: JSON.stringify({
                    email: email,
                    idPedido: localStorage.idPedido
                })
            })
            const content = await response.json()
            if (content.success) {
                localStorage.dataInicio = ""
                localStorage.dataFim = ""
                localStorage.idPedido = ""
                localStorage.petsitters = ""
                localStorage.sucesso = "pedido";
                window.location.replace("http://localhost/pedidosPendentesDono.html")
            }
            else {
                localStorage.sucesso = "erro";
                window.location.replace("http://localhost/selPetsitter.html");
            }
        },
        validarAnimaisData: function () {
            var form_data = $("#animaisdata_form").serializeArray();
            var error_free = true;
            for (var input in form_data) {
                var element = $("#" + form_data[input]['name']);
                var error_element = $("span", element.parent());

                // A fotografia é válida se não estiver preenchida
                if (form_data[input]['name'] == "pic") {
                    if (!element.val()) {
                        element.removeClass("invalid").addClass("valid");
                        error_element.removeClass("error_show").addClass("error");
                    }
                }

                var valid = element.hasClass("valid");

                if (!valid) {
                    error_element.removeClass("error").addClass("error_show");
                    error_free = false;
                    element.removeClass("valid").addClass("invalid");
                }
                else {
                    element.removeClass("invalid").addClass("valid");
                    error_element.removeClass("error_show").addClass("error");
                }
            }

            if (!error_free) {
                // Get the snackbar DIV
                var x = document.getElementById("snackbar");

                // Change content
                x.textContent = "Preencha o formulário corretamente."

                // Add the "show" class to DIV
                x.className = "show";

                // After 3 seconds, remove the show class from DIV
                setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
            }
            else {
                this.registarPedido();
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
                localStorage.sucesso = "registo";
                window.location.replace("http://localhost/adicionarAnimal.html")
            }
            else {
                localStorage.sucesso = "erro";
                window.location.replace("http://localhost/adicionarAnimal.html");
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
            if (this.id != "")
                this.animal.id = this.id
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
        editarDadosDono: async function () {
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
                window.location.replace("http://localhost/perfilDono.html");
            }
            else {
                localStorage.sucesso = "erro";
                window.location.replace("http://localhost/editarDadosDono.html");
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
        pagEditarAnimal: function (id) {
            localStorage.idAnimal = id
            window.location.replace("http://localhost/editarAnimal.html")
        },
        editarAnimal: async function () {
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
                localStorage.sucesso = "editar";
                window.location.replace("http://localhost/editarAnimais.html");
            }
            else {
                localStorage.sucesso = "erro";
                window.location.replace("http://localhost/editarAnimal.html");
            }
        },
        checkData: function (data) {
            var today = new Date();
            let date = data.split("/")
            let dataFim = date[2].split(' ')[0] + "-" + date[1] + "-" + date[0] + ' ' + date[2].split(' ')[1] + ':00'
            let final = new Date(dataFim)
            const diff = final.getTime() - today.getTime()
            if (diff >= 0)
                return true
            else
                return false
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
        pagPetsitter: function (email) {
            localStorage.petsitter = email
            window.location.replace("http://localhost/consultarPetsitter.html")
        },
        getTipo: function (id) {
            var found = this.tiposAnimal.find(function (element) {
                return element.id == id
            })
            return found
        },
        getTipoNome: function (id) {
            var found = this.tiposAnimal.find(function (element) {
                return element.id == id
            })
            if (found != undefined)
                return found.tipo
        },
        cancelarPedido: async function (id) {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/CancelarPedido", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "POST",
                body: JSON.stringify({
                    idPedido: id
                })
            })
            const content = await response.json()
            if (content.success) {
                localStorage.sucesso = "cancelar";
                window.location.replace("http://localhost/pedidosPendentesDono.html");
            }
            else {
                localStorage.sucesso = "erro";
            }
        }
    },
    computed: {
        concelhos: function () {
            return [...new Set(this.petsitters.map(p => p.concelho))]
        },
        distritos: function () {
            return [...new Set(this.petsitters.map(p => p.distrito))]
        },
        petsittersFiltrados: function () {
            var filtrados = this.petsitters

            // Filtrar por concelho
            if(this.selConcelho != "Todos"){
                filtrados = filtrados.filter(p => p.concelho == this.selConcelho)
            }

            // Filtrar por distrito
            if(this.selDistrito != "Todos"){
                filtrados = filtrados.filter(p => p.distrito == this.selDistrito)
            }

            // Filtrar por search
            if (this.search != "") {
                if (this.search.includes("@")) {
                    filtrados = filtrados.filter(p => p.email.toLowerCase().includes(this.search.toLowerCase()))
                }
                else {
                    filtrados = filtrados.filter(p => p.nome.toLowerCase().includes(this.search.toLowerCase()))
                }
            }

            // Ordenação
            if(this.ordenacao == "Ascendente"){
                var sorting = -1
                filtrados.sort((a, b) => a.avaliacaoMedia < b.avaliacaoMedia ? sorting : -sorting)
            }
            else{
                var sorting = 1
                filtrados.sort((a, b) => a.avaliacaoMedia < b.avaliacaoMedia ? sorting : -sorting)
            }

            return filtrados
        }
    }
})