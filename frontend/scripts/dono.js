Vue.component('sidebardono', {
    methods: {
        logout: function () {
            localStorage.token = ""
            window.location.replace("http://localhost/")
        }
    },
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
        pontuacao: 0
    }),
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
                console.log("review feita com sucesso!")
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
                    Avaliar Petsitter - {{ petsitter.nome }}
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
                        <input type="radio" id="star5" v-model="pontuacao" value="5" />
                        <label for="star5" title="text">5 stars</label>
                        <input type="radio" id="star4" v-model="pontuacao" value="4" />
                        <label for="star4" title="text">4 stars</label>
                        <input type="radio" id="star3" v-model="pontuacao" value="3" />
                        <label for="star3" title="text">3 stars</label>
                        <input type="radio" id="star2" v-model="pontuacao" value="2" />
                        <label for="star2" title="text">2 stars</label>
                        <input type="radio" id="star1" v-model="pontuacao" value="1" />
                        <label for="star1" title="text">1 star</label>
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
                window.location.replace("http://localhost/editarAnimais.html")
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
        reviews: [],
        utilizador: {}
    },
    mounted: function () {
        if (localStorage.sucesso == "login") {
            this.snackbar("Login efetuado com sucesso.")
            localStorage.sucesso = ""
        }
        else if (localStorage.sucesso == "registo") {
            this.snackbar("Registo efetuado com sucesso.")
            localStorage.sucesso = ""
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
                    console.log(JSON.stringify(animal))
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
                    localStorage.idAnimal = ""
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
            for (var animal in this.servicosAnimaisSelecionados) {
                var idAnimal = this.servicosAnimaisSelecionados[animal].idAnimal;
                if (!animais.includes(idAnimal))
                    this.animais.push()
            }
            // Ver se os animais que têm serviços são os que foram selecionados
            for (var animal in this.animaisSelecionados) {
                var idAnimal = this.animaisSelecionados[animal];
                if (!animais.includes(idAnimal))
                    ok = false;
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
                window.location.replace("http://localhost/pedidosPendentes.html")
                localStorage.dataInicio = ""
                localStorage.dataFim = ""
                localStorage.idPedido = ""
                localStorage.petsitters = ""
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
                window.location.replace("http://localhost/editarDadosDono.html")
            }
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
                window.location.replace("http://localhost/editarAnimais.html")
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
        }
    }
})