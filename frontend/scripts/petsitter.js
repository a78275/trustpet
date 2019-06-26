Vue.component('sidebarpetsitter', {
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
                    <a href="">Consultar Perfil</a>
                </li>
                <li>
                    <a href="#">Editar Dados Pessoais</a>
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
            <a href="#">Logout</a>
        </li>
    </ul>
</nav>
`
})

var vm = new Vue({
    el: "#petsitter"
})