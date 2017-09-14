# README #
Projeto de DAC 
Requisitos levantados:



- O sistema deve permitir que um usuário novo possa ser cadastrado, esse novo cadastro fica com sua autorização pendente que deve ser feita por um usuário Gerente, o usuário gerente deve receber uma notificação por e-mail que um novo usuário foi cadastrado para que ele possa efetuar a liberação, só após isso o usuário novo poderá logar no sistema.
- Ao se cadastrar o novo usuário deve definir se o mesmo será um candidato ou um funcionário.
- O usuário do tipo candidato poderá se inscrever para as vagas existente, sendo só permitido uma inscrição por vaga, e não permitido que haja choque de horários entre as avaliações agendadas para as vagas. Pode ser anexado preferencias requisitadas no perfil da vaga.

- Um funcionário pode criar vagas e disponibilizá-las, ao criá-las deve informar que tipos de requisitos são necessários tais como “HTML”, “JAVA”, etc...
- Um gerente pode  definir um funcionário como avaliador e fixá-lo a uma avaliação.
- Um gerente pode definir a funcionalidade de um outro funcionário podendo fazê-lo gerente ou avaliador, não sendo permitido que ele mude sua própria funcionalidade.
- Um candidato pode adicionar seu currículo e suas preferencias no seu cadastro após a aprovação.
- O candidato poderá visualizar todas as avaliações agendadas em forma de calendário.
- O funcionário também poderá visualizar todas as avaliações agendadas em forma de calendário.
- O acesso as funcionalidades do sistema por parte do usuário deve ser disponibilizada só após o mesmos logar, que só será permitido a usuários que tenha o seu cadastro autorizado.
- Os candidatos cadastrados podem receber um e-mail informando da existência de novas vagas em forma de relatório assim que as mesmas forem criadas, esse relatório deve ser baseado no perfil do candidato em relação a vaga.
- Os candidatos devem ser notificado por e-mail quando a inscrição tive agendada uma avaliação e se a mesma apresentou choque de horário com alguma outra inscrição.
- Os candidatos deve ser lembrado pelo sistema da data da avaliação.
- O funcionário avaliador pode agendar uma avaliação para cada inscrição feita, podendo ser definida como individual (entrevista)evitando assim o choque de horário com qualquer outra avaliação independente do tipo ou candidato, ou ele pode agendar uma avaliação no mesmo horário para mais de um candidato(prova), desde que esta não apresente choque com uma outra avaliação já agendada no mesmo dia e hora.
- O gerente é que pode definir qual funcionário será o avaliador de uma determinada vaga. Esse por sua vez deve obrigatoriamente definir o perfil deste funcionário como avaliador. Como ele não pode mudar o seu próprio perfil, logo, ele não pode ser auto definir avaliador de uma vaga.
- A analise perfil linkedin e github deve ser usado um processo de peso.

# rhecruta
