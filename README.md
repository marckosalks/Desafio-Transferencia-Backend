## DESAFIO TRANSFERENCIA

Como Planejo fazer esse projeto?

Entidades
 -Transferencia

DTO de entrada 
 -json enviado pelo usuário : 
  contaOrigem, contaDestino, valorTransferencia, dataTransferencia
  (data de agendamento gerado pelo backend)

Serviços
 -Taxa, reponsavel por: 
  calcular a taxas
 
 -Transferencia, reponsavel por:
  validar contas,chamar TaxaService, salvar no banco, listar agendamentos

Endpoits:
POST/entrada de dados
GET/extrato das transferencias
 -Exibir extrato, responsável por:
  verificar ultimas transferencias feitas
  (pode ser tanto no log, quanto no banco)

Exceptions:
Conta inválida
Data da transferência anterior à data atual
Não existe taxa aplicável para o período informado

GlobalExceptionHandler

Para devolver:

{
  "mensagem": "Não existe taxa aplicável para o período informado"
}

ARQUITETURA:

controller
├── TransferenciaController

service
├── TransferenciaService
├── TaxaService

repository
├── TransferenciaRepository

entity
├── Transferencia

dto
├── TransferenciaRequest
├── TransferenciaResponse

exception
├── RegraNegocioException
├── GlobalExceptionHandler
