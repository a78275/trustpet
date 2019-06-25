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
                    <a href="#">Editar Dados Pessoais</a>
                </li>
                <li>
                    <a href="#">Editar Dados dos Animais</a>
                </li>
                <li>
                    <a href="#">Adicionar Animal</a>
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
            <a href="#">Logout</a>
        </li>
    </ul>
</nav>
`
})

var vm = new Vue({
    el: "#dono",
    data: {
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
        petsitters: ['Maria', 'Manel'],
        pedidosPendentes: ['Pedido 1', 'Pedido 2'],
        dataInicio: "",
        dataFim: "",
        horaInicio: "",
        horaFim: ""
    },
    created: async function () {
        if (localStorage.token) {
            //Validar
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/Index", {
                headers: {
                    'Content-Type': 'application/json',
                    'Token': localStorage.token
                },
                method: "GET"
            })
            const content = await response.json()
            if (content.email) {

                //Fetch dos animais
                const responseAnimal = await fetch("http://localhost:8080/trustpet_war_exploded/ConsultarAnimais", {
                    headers: {
                        'Content-Type': 'application/json',
                        'Token': localStorage.token
                    },
                    method: 'GET'
                })
                const contentAnimal = await responseAnimal.json()
                if (contentAnimal.sucess) {
                    this.animais = JSON.parse(contentAnimal.animais)
                }

                //Fetch do dono
                const responseDono = await fetch("http://localhost:8080/trustpet_war_exploded/ConsultarPerfil", {
                    headers: {
                        'Content-Type': 'application/json',
                        'Token': localStorage.token
                    },
                    method: 'GET'
                })
                const contentDono = await responseDono.json()
                if (contentDono.sucess) {
                    console.log(contentDono.nome)
                }
            } else {
                window.location.replace("http://localhost/index.html")
            }
        } else {
            window.location.replace("http://localhost/index.html")
        }
    },
    methods: {
        getServicos: function (id) {
            var found = this.servicos.find(function (element) {
                return element.id == id
            });
            return found.servicos
        }
    }
})