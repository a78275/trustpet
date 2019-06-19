<template>
<div class="row">
        <div class="d-none d-sm-block" id="side">
            <img @click="index()" src="../assets/logo.png" class="mt-5 mx-auto d-block" width="250" id="logo"/>
        </div>
        <div id="side2">
            <div class="row">
                <div class="col-12 d-flex justify-content-center">
                    <form class="m-5" id="login_form" action="http://localhost:8070/Autenticar" method="post" enctype="application/x-www-form-urlencoded">
                        <h1 class="text-center p-5" style="color:#545871; font-size:4em;">LOGIN</h1>
                        <br><br><br>
                        <div class="form-group">
                            <label for="email" style="color:#545871;">E-mail</label>
                            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                                placeholder="Endereço de e-mail">
                        </div>
                        <div class="form-group">
                            <label for="password" style="color:#545871;">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="********">
                        </div>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Concordo com os Termos de Utilização e a
                                Política de Privacidade.</label>
                        </div>
                        <br>
                        <div class="text-center">
                            <button type="submit" class="btn" id="whitebtn">Entrar</button>
                        </div>
                    </form>
                </div>
            </div>
            <footer class="footer py-2">
                <div class="container mt-4 text-center">
                    <p id="registerask">Ainda não tem conta?<button @click="registar()" type="submit" class="btn" id="darkbluebtn">Registar</button></p>
                </div>
            </footer>
        </div>
    </div>
</template>

<script>
export default {
    methods: {
        index: function () {
            this.$router.push('/')
        },
        registar: function () {
            this.$router.push('/Registar')
        }
    }
}
</script>
