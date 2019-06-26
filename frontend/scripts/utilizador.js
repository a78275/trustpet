Vue.component('side', {
    template: `
<div class="d-none d-sm-block" id="side">
    <img src="../img/logo.png" class="mt-5 mx-auto d-block" width="250" id="logo" />
</div>
`
})

var vm = new Vue({
    el: "#utilizador",
    data: {
        email: "",
        password: "",
        nome: "",
        dataNasc: "",
        contacto: "",
        morada: "",
        jardim: "",
        distrito: "",
        concelho: "",
        avatar: "",
        tiposAnimal: [{ 'id': '1', 'tipo': 'Gato', 'img': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSf5fBKv_d93io82eZokxqn_4jsHFSolEpiqeNPxjxy12DIiM0T' }, { 'id': '2', 'tipo': 'Cão', 'img': 'https://essencecuidados.com.br/wp-content/uploads/2016/10/dog.jpg' }, { 'id': '3', 'tipo': 'Pássaro', 'img': 'https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/04/10/19/pinyon-jay-bird.jpg' }, { 'id': '4', 'tipo': 'Tartaruga', 'img': 'https://oliveridleyproject.org/wp-content/uploads/2018/05/Olive-ridley-turtle-baby-patient-Luna-recovering-rescue-centre-ORP.jpg' }],
        servicos: [{ 'id': '1', 'designacao': 'Tomar conta' }, { 'id': '2', 'designacao': 'Levar à rua' }, { 'id': '3', 'designacao': 'Alimentar' }, { 'id': '4', 'designacao': 'Dar banho' }],
        tipo: "",
        utilizador: {},
        animais: [],
        tiposAnimaisSelecionados: [],
        preco1: "",
        preco2: "",
        preco3: "",
        preco4: "",
        horario: []
    },
    methods: {
        registoPetsitter: async function () {
            console.log("registo petsitter")
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/RegistarPetsitter", {
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
                window.location.replace("http://localhost/registoTiposAnimais.html")
            }
            else {
                window.location.replace("http://localhost/registoPerfilPetsitter.html")
            }
        },
        registoTiposAnimais: async function () {
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
                window.location.replace("http://localhost/registoServicos.html")
            }
        },
        registoServicos: async function () {
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
                window.location.replace("http://localhost/registoHorario.html")
            }
        },
        registoHorario: async function () {
            const response = await fetch("http://localhost:8080/trustpet_war_exploded/EditarHorario", {
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Token': localStorage.token
                },
                method: "POST",
                body: JSON.stringify({
                    horario: this.horario
                })
            })
            const content = await response.json()
            console.log(JSON.stringify(content))
            if (content.success) {
                window.location.replace("http://localhost/indexPetsitter.html")
            }
        },
        login: async function () {
            if (this.email === '' || this.password === '') {
                // Get the snackbar DIV
                var x = document.getElementById("snackbar");

                // Change content
                x.textContent = "O email e a password são campos obrigatórios."

                // Add the "show" class to DIV
                x.className = "show";

                // After 3 seconds, remove the show class from DIV
                setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
            }
            else {
                const response = await fetch("http://localhost:8080/trustpet_war_exploded/Autenticar", {
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    method: "POST",
                    body: JSON.stringify({
                        email: this.email,
                        password: this.password
                    })
                })
                const content = await response.json()

                if (content.success) {
                    localStorage.token = content.token
                    this.token = content.token
                    if (content.tipo == "dono") {
                        window.location.replace("http://localhost/indexDono.html")
                    } else if (content.tipo == "petsitter") {
                        window.location.replace("http://localhost/indexPetsitter.html")
                    }
                }
                else {
                    // Get the snackbar DIV
                    var x = document.getElementById("snackbar");

                    // Change content
                    x.textContent = "Credenciais erradas."

                    // Add the "show" class to DIV
                    x.className = "show";

                    // After 3 seconds, remove the show class from DIV
                    setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
                }
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
        criarUtilizador: async function () {
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
        registo: function () {
            if (this.tipo == "dono") {
                window.location.replace("http://localhost/registoPerfilDono.html")
            } else if (this.tipo == "petsitter") {
                window.location.replace("http://localhost/registoPerfilPetsitter.html")
            }
        }
    }
})