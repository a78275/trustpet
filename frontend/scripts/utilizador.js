Vue.component('trustpetinfo', {
    template: `
<div>
    <!-- Services -->
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h3 class="section-subheading"><b>Opções destinadas às suas necessidades.</b></h3>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-4" id="service">
                    <span class="fa-stack fa-4x">
                        <i class="fas fa-circle fa-stack-2x"></i>
                        <i class="fas fa-tree fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Passeio</h4>
                    <p class="text-muted">Passeamos o seu animal, limpamos dejetos e asseguramos a hidratação do
                        mesmo.</p>
                </div>
                <div class="col-4" id="service">
                    <span class="fa-stack fa-4x">
                        <i class="fas fa-circle fa-stack-2x"></i>
                        <i class="fas fa-home fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading"><i>Petsitting</i> em sua casa</h4>
                    <p class="text-muted">Tomamos conta do seu animal em sua casa, assegurando conforto,
                        alimentação, hidratação, carinho e brincadeiras.</p>
                </div>
                <div class="col-4" id="service">
                    <span class="fa-stack fa-4x">
                        <i class="fas fa-circle fa-stack-2x"></i>
                        <i class="fas fa-bed fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading"><i>Petsitting</i> em casa do <i>Petsitter</i></h4>
                    <p class="text-muted">Tomamos conta do seu animal, assegurando conforto, alimentação,
                        hidratação, carinho e brincadeiras.</p>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact -->
    <section id="contacts">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <p id="contacttext" class="section-subheading">Contacte-nos!</p>
                    <p id="email">trustpet@email.com</p>
                </div>
            </div>
        </div>
    </section>
</div>`
})

Vue.component('side', {
    template: `
<div class="d-none d-sm-block" id="side">
    <a href="index.html"><img src="../img/logo.png" class="mt-5 mx-auto d-block" width="250" id="logo" /></a>
</div>
`
})

var vm = new Vue({
    el: "#utilizador",
    data: {
        appName: "TrustPet",
        email: "",
        password: ""
        //msg: ""
    },
    created: async function () {
        if (localStorage.token) {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/Index", {
                headers: {
                    'Content-Type': 'application/json',
                    'Token': localStorage.token
                },
                method: "GET"
            })
            const content = await response.json()
            if (content.email) {
                if (content.tipo == 'dono') {
                    window.location.replace("http://localhost/indexDono.html")
                } else if (content.tipo == 'petsitter') {
                    //window.location.replace("http://localhost/indexPetsitter.html")
                }
            }
        }
    },
    methods: {
        login: async function () {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/Autenticar", {
                headers: {
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify({
                    email: this.email,
                    password: this.password
                })
            })
            const content = await response.json()

            if (content.sucess) {
                localStorage.token = content.token
                this.token = content.token
                if (content.tipo == "dono") {
                    window.location.replace("http://localhost/indexDono.html")
                } else if (content.tipo == "petsitter") {
                    window.location.replace("http://localhost/indexPetsitter.html")
                }
            }
        }
    }
})