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
                <li>
                    <a href="#">Remover Animal</a>
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
        appName: "TrustPet",
        animais: [],
        servicos: [{ 'id': '1', 'servicos': { '1': 'Passear', '2': 'Dar banho' } }, { 'id': '2', 'servicos': { '1': 'Passear', '4': 'Alimentar', '5': 'Coçar as costas', '6': 'Escovar o pêlo', '7': 'Brincar' } }],
        petsitters: ['Maria', 'Manel']
    },
    created: async function () {
        this.animais = [{ "id": 1, "tipo": { "id": 1, "tipo": "Gato" }, "nome": "Luna", "avatar": "", "idade": 1, "sexo": "F", "alergias": "", "doenças": "Doente da cabeça, muito lindinha e querida e come plástico.", "comportamento": "Falta de noção de espaço.", "vacinas": false, "desparasitacao": true, "esterilizacao": true, "raca": "Engodo", "ativo": true, "porte": "pequeno" }, { "id": 2, "tipo": { "id": 2, "tipo": "Cão" }, "nome": "Asdrubal", "avatar": "", "idade": 1, "sexo": "M", "alergias": "pão", "doenças": "Doente da cabeça", "comportamento": "Falta de noção de espaço.", "vacinas": true, "desparasitacao": true, "esterilizacao": false, "raca": "Engodo", "ativo": true, "porte": "pequeno" }, { "id": 3, "tipo": { "id": 1, "tipo": "Gato" }, "nome": "Luna", "avatar": "", "idade": 1, "sexo": "F", "alergias": "pão", "doenças": "Doente da cabeça", "comportamento": "Falta de noção de espaço.", "vacinas": true, "desparasitacao": false, "esterilizacao": true, "raca": "Engodo", "ativo": true, "porte": "pequeno" }, { "id": 4, "tipo": { "id": 1, "tipo": "Gato" }, "nome": "Luna", "avatar": "", "idade": 1, "sexo": "F", "alergias": "pão", "doenças": "Doente da cabeça", "comportamento": "Falta de noção de espaço.", "vacinas": true, "desparasitacao": true, "esterilizacao": true, "raca": "Engodo", "ativo": true, "porte": "pequeno" }, { "id": 5, "tipo": { "id": 1, "tipo": "Gato" }, "nome": "Luna", "avatar": "", "idade": 1, "sexo": "F", "alergias": "pão", "doenças": "Doente da cabeça", "comportamento": "Falta de noção de espaço.", "vacinas": true, "desparasitacao": true, "esterilizacao": true, "raca": "Engodo", "ativo": true, "porte": "pequeno" }]
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
