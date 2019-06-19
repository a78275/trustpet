<template>
    <div class="wrapper">
        <!-- Page Content -->
        <div id="contentfull">
            <!-- Description -->
            <section class="intro-text" id="description">
                <div class="row">
                    <div class="col-lg-7 col-md-5 col-sm-2">
                    </div>
                    <div class="col-lg-5 col-md-7 col-sm-10">
                        <img src="../assets/logo.png" class="mx-auto" width="200" />
                        <div id="slogan">
                            <b>Cuidamos dos seus animais enquanto está fora!</b>
                        </div>
                        <a id="whitebtn" class="btn btn-xl" @click="login()">Login</a>
                        <p id="registerask">Ainda não tem conta? <a href="#">Registe-se!</a></p>
                    </div>
                </div>
            </section>
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
        </div>
    </div>
</template>

<style lang="scss">
</style>

<script>
export default {
    methods: {
        login: function () {
            this.$router.push('/login')
        }
    }
}
</script>
