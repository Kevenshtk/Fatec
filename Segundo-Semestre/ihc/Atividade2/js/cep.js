function buscarEndereco() {
    var cep = document.getElementById('cep').value;

    if (cep.length !== 8) {
        Swal.fire("O CEP deve ter 8 dígitos");
        return;
    }

    $.ajax({
        url: `https://viacep.com.br/ws/${cep}/json/`,
        type: 'GET',
        success: function(response) {
            document.getElementById('logradouro').value = response.logradouro;
            document.getElementById('cidade').value = response.localidade;
            document.getElementById('bairro').value = response.bairro;
            document.getElementById('estado').value = response.uf;
        },
        error: function(xhr, status, error) {
            console.error('Erro ao buscar o CEP:', error);
            alert('Erro ao buscar o CEP. Por favor, verifique se o CEP está correto e tente novamente.');
        }
    });
}

document.getElementById('btn-buscar').addEventListener('click', buscarEndereco);