document.getElementById('btn-enviar').addEventListener('click', function() {
    var nome = document.getElementById('nome').value;
    var celular = document.getElementById('celular').value;
    var email = document.getElementById('email').value;
    var empresa = document.getElementById('empresa').value;
    var logradouro = document.getElementById('logradouro').value;
    var numero = document.getElementById('numero').value;
    var bairro = document.getElementById('bairro').value;
    var cidade = document.getElementById('cidade').value;
    var estado = document.getElementById('estado').value;

    var regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    var regexCelular = /^\(\d{2}\) \d{5}-\d{4}$/;

    var palestrasSelecionadas = document.querySelectorAll('input[type="checkbox"]:checked');

    if(!nome){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Por favor, preencha seu nome."
        });

    } else if(!celular || !regexCelular.test(celular)){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            html: "Por favor, preencha seu celular.<br> Ex.:(99) 99999-9999"
        });

    } else if(!email || !regexEmail.test(email)){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Por favor, preencha seu email."
        });

    } else if(!empresa){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Por favor, preencha sua empresa."
        });

    } else if(palestrasSelecionadas.length === 0){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Por favor, escolha pelo menos uma palestra."
        });

    } else if(!logradouro){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Por favor, preencha seu logradouro."
        });

    } else if(!numero ){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Por favor, preencha seu número."
        });

    } else if(!bairro ){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Por favor, preencha seu bairro."
        });

    } else if(!cidade){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Por favor, preencha sua cidade."
        });

    } else if(!estado){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Por favor, preencha seu estado."
        });

    } else {
        Swal.fire({
            title: "Quase lá...",
            text: "Deseja enviar sua inscrição?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sim"
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire({
                    title: "Muito bom!",
                    text: "Inscrição enviada com sucesso",
                    icon: "success",
                    showCancelButton: true,
                    confirmButtonColor: "#3085d6",
                    cancelButtonColor: "#d33",
                    confirmButtonText: "Sim, outra inscrição",
                    cancelButtonText: "Não, obrigado"
                }).then((result) => {
                    if (result.isConfirmed) {
                        document.getElementById("formInscricao").reset();
                    } else {
                        document.getElementById("formInscricao").reset();
                    }
                });
            }
        });
        
    }
});