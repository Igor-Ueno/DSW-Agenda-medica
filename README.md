# DSW1 - Sistema de Agendamento de Consultas Médicas

## Problemas que ainda precisam ser resolvidos:
* Texto com acentuação fica desformatado ocasionalmente.
* Campo de data precisa ser revisto (se está armazenado e imprimindo valores da forma esperada).
* Campo de hora precisa de um tipo espeical de dado para tempo ou realizar alguma padronização no seu formato (atualmente é apenas uma string).
* No cadastro de uma consulta, o campo CRM do médico é textual, deve ser um menu suspenso com os CRMs dos médicos cadastrados no sistema.

## Requisitos faltantes
* R3, R4 ainda não foram implementados.
* Regras de negócio precisam ser implementadas, o que inclui, mas não se limita a:
  * Duração de 30 minutos de cada consulta;
  * Inicio das consultas apenas em hora cheia (10h00) ou meia hora (10h30);
  * Envio de e-mail informando sobre a consulta para paciente e médico (não faço ideia de como fazer isso);
  * Requisito R7;
  * Tratamento de todos os possíveis erros;
    * Página de erro amigável;
    * Registro do erro no console.
