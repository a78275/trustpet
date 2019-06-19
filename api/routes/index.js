var express = require('express');
var router = express.Router();
var axios = require('axios')

var url = 'http://localhost:8080/projeto_war_exploded/'

getResponse = async (url) => {
  try {
    var response = await axios.get(url);
    return (response.data);
  }
  catch (erro) {
    return ('ERRO: ' + erro)
  }
}

/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/pedidosPendentes', async function (req, res, next) {
  var response = await getResponse(url + '')
  res.jsonp(response)
});

router.get('/consultarPetsitters', async function (req, res, next) {
  var response = await getResponse(url + 'ConsultarPetsitters')
  res.jsonp(response)
});

router.post('/Autenticar', function (req, res, next) {
  axios.post('http://localhost:8080/TrustPet_Web_exploded/Autenticar', {
    email: req.body.email,
    password: req.body.password
  }).then(function (response) {
    res.jsonp(response);
  })
    .catch(function (error) {
      console.log(error);
    });
  /*
  axios({
    method: 'post',
    url: '/user/12345',
    data: {
      firstName: 'Fred',
      lastName: 'Flintstone'
    }
  });*/
  //var response = await getResponse(url + 'ConsultarPetsitters')
  //res.jsonp(response)
});

module.exports = router;
