$.validator.setDefaults({
    submitHandler: function(){
        $("#status").html("Login realizado com sucesso");
    }
});
$(document).ready(function(){
    $("#login").validate({
        // Define as regras
        rules:{
            nomeUsuario:{
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true,
                minlength: 3
            },
            senha:{
                // campoMensagem será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true,
                minlength: 3
            },
            kaptcha:{
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true,
                kaptcha: true
            }
        },
        // Define as mensagens de erro para cada regra
        messages:{
            nomeUsuario:{
                required: "Digite o seu nome",
                minLength: "O seu nome deve conter, no mínimo, 3 caracteres"
            },
            senha:{
                required: "Digite a sua senha",
                minLength: "A sua senha deve conter, no mínimo, 3 caracter"
            },
            kaptcha:{
                required: "Digite o código acima",
                kaptcha: "Digite um código válido"
            }
        }
    });
});