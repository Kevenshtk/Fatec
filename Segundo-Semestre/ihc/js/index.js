const campos = [
  "nome",
  "celular",
  "email",
  "empresa",
  "palestras",
  "logradouro",
  "numero",
  "bairro",
  "cidade",
  "estado",
];

const regular = {
  celular: /^\(\d{2}\) \d{5}-\d{4}$/,
  email: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
};

const validarCampo = (campo) => {
  switch (campo) {
    case "nome":
    case "empresa":
    case "logradouro":
    case "numero":
    case "bairro":
    case "cidade":
    case "estado":
      if ($(`#${campo}`).val().trim() == "") {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: `Por favor, preencha seu ${campo}.`,
        });

        return true;
      }
      break;

    case "celular":
      if (
        !$(`#${campo}`).val() ||
        !regular.celular.test($(`#${campo}`).val())
      ) {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          html: "Por favor, preencha seu celular.<br> Ex.:(99) 99999-9999",
        });

        return true;
      }
      break;

    case "email":
      if (!$(`#${campo}`).val() || !regular.email.test($(`#${campo}`).val())) {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Por favor, preencha seu email.",
        });

        return true;
      }
      break;

    case "palestras":
      const palestrasSelecionadas = $('input[type="checkbox"]:checked')
      if (palestrasSelecionadas.length === 0) {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Por favor, escolha pelo menos uma palestra.",
        });

        return true;
      }
      break;
  }
}

$("#btn-avancar").click(function () {
  $("#containerFormInscricao").removeClass("selecionado");
  $("#containerFormEndereco").addClass("selecionado");
});

$("#btn-voltar").click(function () {
  $("#containerFormEndereco").removeClass("selecionado");
  $("#containerFormInscricao").addClass("selecionado");
});

$(document).ready(function () {
  $("#btn-enviar").click(function () {
    for (const campo of campos) {
      const erro = validarCampo(campo);
      if (erro) return;
    }

    Swal.fire({
      title: "Quase lá...",
      text: "Deseja enviar sua inscrição?",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Sim",
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
          cancelButtonText: "Não, obrigado",
        }).then((result) => {
          result.isConfirmed
            ? document.getElementById("formInscricao").reset()
            : document.getElementById("formInscricao").reset();
        });
      }
    });
  });
});

$("#btn-buscar").click(function () {
  let cep = $("#cep").val();

  if (cep.length !== 8) {
    Swal.fire("O CEP deve ter 8 dígitos");
    return;
  }

  $.ajax({
    url: `https://viacep.com.br/ws/${cep}/json/`,
    type: "GET",
    success: function (response) {
      $("#logradouro").val(response.logradouro);
      $("#cidade").val(response.localidade);
      $("#bairro").val(response.bairro);
      $("#estado").val(response.uf);
    },
    error: function (error) {
      console.error("Erro ao buscar o CEP:", error);
      alert(
        "Erro ao buscar o CEP. Por favor, verifique se o CEP está correto e tente novamente."
      );
    },
  });
});
