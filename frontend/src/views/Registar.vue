<template>
    <div class="wrapper">
        <div class="d-none d-sm-block" id="side">
            <img @click="index()" src="../assets/logo.png" class="mt-5 mx-auto d-block" width="250" id="logo"/>
        </div>
        <div id="side2">
            <div class="row">
                <div class="col-12 d-flex justify-content-center">
                    <h3 class="text-center p-5 m-5" id="title" style="color:#545871; font-size:3em;">Como pretende
                        registar-se?
                    </h3>
                    <br><br><br>
                </div>
                <div class="col-12 d-flex justify-content-center">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-6">
                                    <img src="../assets/dono.png" id="avatar" class="mx-3 d-block" width="200" />
                                </div>
                                <div class="col-6">
                                    <img src="../assets/petsitter.png" id="avatar" class="mx-3 d-block" width="200" />
                                </div>
                            </div>
                            <div class="form-check">
                                <div class="row mt-3">
                                    <div class="col-6">
                                        <input class="form-check-input mx-3" type="radio" name="typeuser" id="dono"
                                            value="dono">
                                        <label class="form-check-label mx-5" for="typeuser" id="radio">Dono</label>
                                    </div>
                                    <div class="col-6">
                                        <input class="form-check-input mx-3" type="radio" name="typeuser" id="petsitter"
                                            value="petsitter">
                                        <label class="form-check-label mx-5" for="typeuser" id="radio">Petsitter</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="row">
                <div class="col-6 text-center my-3">
                    <button @click="login()" id="#whitebtn" type="submit" class="btn border">Voltar</button>
                </div>
                <div class="col-6 text-center my-3">
                    <button id="darkbluebtn" class="btn">Seguinte</button>
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
        login: function () {
            this.$router.push('/Autenticar')
        }
    }
}
</script>
