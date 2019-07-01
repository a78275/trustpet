Vue.component('sidebarpetsitter', {
    methods: {
        logout: async function () {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded.war/Logout", {
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
        <a href="indexPetsitter.html"><img src="../img/logo.png" width="200" /></a>
    </div>
    <ul class="list-unstyled components">
        <li>
            <a href="perfilPetsitter.html">Consultar Perfil</a>
        </li>
        <li>
            <a href="pedidosPendentesPetsitter.html">Pedidos Pendentes</a>
        </li>
        
        <li class="sec2">
            <a href="editarDadosPetsitter.html">Editar Dados Pessoais</a>
        </li>
        <li class="sec2">
            <a href="editarTiposAnimais.html">Editar Tipos Animais</a>
        </li>
        <li class="sec2">
            <a href="editarServicos.html">Editar Serviços Fornecidos</a>
        </li>
        <li class="sec2">
            <a href="editarHorario.html">Editar Horário</a>
        </li>

        <li class="sec3">
            <a href="#">Notificações</a>
        </li>
        <li class="sec3">
            <a href="#">Chat</a>
        </li>
        <li class="sec4">
            <a v-on:click="logout()">Logout</a>
        </li>
    </ul>
</nav>
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


Vue.component('avaliar-dono', {
    props: ['dono'],
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
        this.id1 = this.$props.dono + '1'
        this.id2 = this.$props.dono + '2'
        this.id3 = this.$props.dono + '3'
        this.id4 = this.$props.dono + '4'
        this.id5 = this.$props.dono + '5'
    },
    methods: {
        avaliar: async function (id) {
            if (this.pontuacao == 0) {
                this.snackbar("Selecione uma classificação.")
            } else {
                const response = await fetch("http://localhost:8080/trustpet_war_exploded.war/AvaliarUtilizador", {
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
                    localStorage.sucesso = "review"
                } else {
                    localStorage.sucesso = "erro"
                }
                window.location.replace("http://localhost/pedidosPendentesPetsitter.html")
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
            setTimeout(function () {
                x.className = x.className.replace("show", "");
            }, 3000);
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
                    Avaliar Dono - {{ dono }}
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
                            placeholder="Faça um comentário ao dono"></textarea>
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
                <button type="button" v-on:click="avaliar(dono)"
                    style="font-size: 1em; padding-right: 20px; padding-left: 20px;"
                    id="bluepinkbtn">Enviar</button>
            </div>
        </div>
    </div>
</div>
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
        listaServicos: [{
                'id': '1',
                'designacao': 'Petsitting em casa do petsitter'
            },
            {
                'id': '2',
                'designacao': 'Petsitting em casa do dono'
            },
            {
                'id': '3',
                'designacao': 'Passear'
            },
            {
                'id': '4',
                'designacao': 'Alimentar'
            },
            {
                'id': '5',
                'designacao': 'Dar banho'
            },
            {
                'id': '6',
                'designacao': 'Limpeza do ambiente animal'
            },
            {
                'id': '7',
                'designacao': 'Tosquiar'
            },
            {
                'id': '8',
                'designacao': 'Entreter'
            }
        ],
        tiposAnimal: [{
                'id': '1',
                'tipo': 'Gato',
                'img': 'img/gato.png'
            },
            {
                'id': '2',
                'tipo': 'Cão',
                'img': 'img/cao.png'
            },
            {
                'id': '3',
                'tipo': 'Pássaro',
                'img': 'img/passaro.png'
            },
            {
                'id': '4',
                'tipo': 'Tartaruga',
                'img': 'img/tartaruga.png'
            },
            {
                'id': '5',
                'tipo': 'Peixe',
                'img': 'img/peixe.png'
            },
            {
                'id': '6',
                'tipo': 'Porco',
                'img': 'img/porco.png'
            },
            {
                'id': '7',
                'tipo': 'Coelho',
                'img': 'img/coelho.png'
            },
            {
                'id': '8',
                'tipo': 'Roedor',
                'img': 'img/roedor.png'
            },
            {
                'id': '9',
                'tipo': 'Réptil',
                'img': 'img/reptil.png'
            }
        ],
        tiposAnimaisSelecionados: [],
        servicos: [],
        preco1: "",
        preco2: "",
        preco3: "",
        preco4: "",
        preco5: "",
        preco6: "",
        preco7: "",
        preco8: "",
        horario: [],
        novoHorario: [],
        pedidosPendentes: [],
        dono: {}
    },
    mounted: function () {
        if (localStorage.sucesso == "login") {
            this.snackbar("Login efetuado com sucesso.")
            localStorage.sucesso = "";
        } else if (localStorage.sucesso == "registo") {
            this.snackbar("Registo efetuado com sucesso.")
            localStorage.sucesso = "";
        } else if (localStorage.sucesso == "editar") {
            this.snackbar("Dados editados com sucesso.")
            localStorage.sucesso = "";
        } else if (localStorage.sucesso == "pedido") {
            this.snackbar("Pedido efetuado com sucesso.")
            localStorage.sucesso = "";
        } else if (localStorage.sucesso == "erro") {
            this.snackbar("Ocorreu um erro. Tente novamente.")
            localStorage.sucesso = "";
        } else if (localStorage.sucesso == "remover") {
            this.snackbar("Animal removido com sucesso.")
            localStorage.sucesso = "";
        } else if (localStorage.sucesso == "review") {
            this.snackbar("Avaliação efetuada com sucesso.")
            localStorage.sucesso = "";
        } else if (localStorage.sucesso == "cancelar") {
            this.snackbar("Pedido cancelado com sucesso.")
            localStorage.sucesso = "";
        }
    },
    created: async function () {
        if (localStorage.token) {
            //Validar
            const response = await fetch("http://localhost:8080/trustpet_war_exploded.war/Index", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "GET"
            })
            const content = await response.json()
            if (content.email) {

                //Fetch do petsitter
                const responsePetsitter = await fetch("http://localhost:8080/trustpet_war_exploded.war/ConsultarPerfil", {
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
                    let newDate = +date[2] + "-" + date[1] + "-" + date[0]
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
                        if (found.id == '5')
                            this.preco5 = s.preco
                        if (found.id == '6')
                            this.preco6 = s.preco
                        if (found.id == '7')
                            this.preco7 = s.preco
                        if (found.id == '8')
                            this.preco8 = s.preco
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
                if (window.location.href == "http://localhost/consultarDono.html") {
                    const responseDono = await fetch("http://localhost:8080/trustpet_war_exploded.war/ConsultarPerfil", {
                        headers: {
                            'Content-Type': 'application/json; charset=utf-8',
                            'Token': localStorage.token
                        },
                        method: 'POST',
                        body: JSON.stringify({
                            emailConsulta: localStorage.dono
                        })
                    })
                    const contentDono = await responseDono.json()
                    if (contentDono.success) {
                        this.dono = contentDono.utilizador
                        this.dono.reviews = contentDono.reviews
                    }
                }
                const responsePedidos = await fetch("http://localhost:8080/trustpet_war_exploded.war/ConsultarPedidos", {
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
            var found = Array.from(this.horario.dias).find(function (element) {
                if (element != undefined)
                    return element.dia == dia
                else
                    return false
            })
            var founded

            if (found != undefined) {
                founded = found.horas.find(function (element) {
                    return element.hora == hora
                })
            } else
                founded = undefined

            if (founded != undefined)
                return true
            else
                return false
        },
        editarDadosPetsitter: async function () {
            console.log('olá')
            const response = await fetch("http://localhost:8080/trustpet_war_exploded.war/EditarDadosPessoais", {
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
            } else {
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
            setTimeout(function () {
                x.className = x.className.replace("show", "");
            }, 3000);
        },
        camposObrigatorios: async function () {
            // Get the snackbar DIV
            var x = document.getElementById("snackbar");

            // Change content
            x.textContent = "É necessário preencher todos os campos obrigatórios."

            // Add the "show" class to DIV
            x.className = "show";

            // After 3 seconds, remove the show class from DIV
            setTimeout(function () {
                x.className = x.className.replace("show", "");
            }, 3000);
        },
        editarTiposAnimais: async function () {
            if (this.tiposAnimaisSelecionados.length == 0) {
                this.snackbar("É necessário selecionar pelo menos um tipo de animal.")
            } else {
                const response = await fetch("http://localhost:8080/trustpet_war_exploded.war/EditarTiposAnimais", {
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
                } else {
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

            console.log(servicosSelecionados)

            if (servicosSelecionados.length == 0) {
                this.snackbar("Preencha pelo menos um serviço.")
            } else {
                const response = await fetch("http://localhost:8080/trustpet_war_exploded.war/EditarServicos", {
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
                } else {
                    localStorage.sucesso == "erro";
                    window.location.replace("http://localhost/editarServicos.html")
                }
            }
        },
        editarHorario: async function () {
            if (this.horario.length == 0) {
                this.snackbar("Selecione pelo menos uma hora.")
            } else {
                const response = await fetch("http://localhost:8080/trustpet_war_exploded.war/EditarHorario", {
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
                } else {
                    localStorage.sucesso == "erro";
                    window.location.replace("http://localhost/editarHorario.html")
                }
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
        pagDono: function (email) {
            localStorage.dono = email
            window.location.replace("http://localhost/consultarDono.html")
        },
        cancelarPedido: async function (id) {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded.war/CancelarPedido", {
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
                //localStorage.sucesso = "cancelar";
                window.location.replace("http://localhost/pedidosPendentesPetsitter.html");
            } else {
                localStorage.sucesso = "erro";
            }
        }
    }
})