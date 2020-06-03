# TDS-RPG

Projeto TDS
Cyberpunk 1966


Classe Personagem (abstrata):
{
Atributos: 
- Pontos de vida (atual/máx);
	- Fé (atual/base/efetiva);
	- Chance de Crítico (atual/base/efetiva);
	- Inteligência (atual/base/efetiva);
	- Força (atual/base/efetiva);
	- Destreza (atual/base/efetiva);
	- Sorte (atual/base/efetiva);
	- Resistência a dano gera (atual/base/efetiva);
	- Nível;

Métodos: 
- Personagem();
- Atacar();
- Morrer();
- Gets() & sets();
};






Classe PersonagemJogavel:
{
Atributos:
 	- Experiência no nível atual;
	- Inventário;
	- Equipamentos;
	- Ouro;

Métodos:
	- PersonagemJogavel();
	- Passiva();
	- HabilidadeUm();
	- HabilidadeDois();
	- HabilidadeSuprema();
	- GetExperiência();
	- SetExperiência();
	- SubirDeNivel();

};

Classe Chefe:
{
Atributos:
	- Inventário;
	- Recompensas;
	
Métodos:
	- Chefe();
	- Passiva();
	- HabilidadeUm();
	- HabilidadeDois();
	- HabilidadeSuprema();
};
Classe Inimigo:
{
Atributos:
	- Recompensas;

Métodos:
	- Inimigo();
	- Habilidade();
};


Habilidades:
	- Passiva: o personagem jogável terá uma habilidade passiva que será ativada conforme os dados jogados em cada turno.
	- Duas habilidades normais e uma habilidade suprema (ultimate) (O tempo de recarga das habilidades será por turnos e a habilidade suprema será carregada somando os valor dos dados jogados em cada turno)
	- Barra de dado extra: Carregada pelo complemento do valor adquirido nos dados (Valor máximo - Valor adquirido). Essa barra auxiliará jogadores com má sorte e concederá um dado de dez faces quando for ativada, esse dado extra será somado aos outros dados no turno em que a barra for usada.





Combate:
-	Rolagem normal (um dado de 6 faces e um de 10 faces uso único);
-	Rolagem simultânea;
-	Turno (ambos);
-	Quem começa é escolhido aleatoriamente;



Classes:

-	Mago Elemental
	{
		Passiva: Correntes de Vinhas - Prende um dos dados do inimigo;

		Habilidade 1: Bola de fogo - Causa dano baseado na inteligência e deixa o                   inimigo pegando fogo por N turnos (também causando dado com base em inteligência);

		Habilidade 2: Fúria dos Ventos - Lança os dados inimigos novamente com valores menores que os atuais e causa dano baseado na inteligência;

		Habilidade suprema: Ice Barrage - Congela os inimigos com base nos dados impossibilitando eles de realizaram ações (x turnos) e causa dano baseado na inteligência.
	}



	- Cavaleiro
{
		Passiva: Escudo de Espinhos - Reflete uma porcentagem (baseada em força) do dano recebido do próximo ataque (uma vez a cada N turnos);
		Habilidade 1: Grito de Guerra - Ataque com chance de N% (baseado nos dados) de atordoar até 2 inimigos e causa dano baseado em força;
		Habilidade 2: Uppercutter - Ataque causando dano a um inimigo baseado em força.
		Habilidade Suprema: Armadura dos Deuses - Bloqueia N% de dano pelos próximos N turnos baseado em fé e resistência (20% baseado em fé e 80% em resistência);
}
	





- Ladino

{
		Passiva: Dedos Leves - Recebe X% a mais de ouro de todas as fontes.Cleptomaníaco - Quando ativada, ganha um item consumível aleatório. Caso não haja espaço no inventário, o item é consumido automaticamente.
		Habilidade 1: Esquiva Perfeita - 100% de chance de esquiva no próximo ataque inimigo (N [alto] turnos de recarga).
		Habilidade 2: Corte Sombrio - Usa a Destreza do assassino para se aproximar e efetuar um golpe com a adaga causando dano baseado na destreza e nos dados.
		Habilidade Suprema: Marca Fatal - Seleciona um inimigo e o aplica a Marca Fatal, uma porcentagem de todo o dano causado ao inimigo enquanto estiver marcado será aplicado quando a marca ativar.
}	


	- Arqueiro
	{
		Passiva: O arqueiro realiza duas ações no mesmo turno.
		Habilidade 1: Na Mosca - Causa dano baseado na Destreza e na Força do jogador (75% destreza e 25% força);
		Habilidade 2: Flechada no Joelho - Atinge o alvo adversário no joelho, diminuindo seu atributo de ataque de maior valor em N (baseado na Destreza do jogador);
		Habilidade Suprema: Chuva de Flechas - Causa dano massivo e verdadeiro em área, afetando todos os inimigos em combate (baseado na destreza e na força [60% destreza e 40% Força])
	}
 

	- Paladino
{
		Passiva: Auxílio dos Céus - Cura uma porcentagem de vida baseado na Fé e na vida perdida do personagem;
		Habilidade 1: Investida Celestial - Causa dano (baseado em Fé), ignorando uma porcentagem (baseada nos dados) da resistência do inimigo;
		Habilidade 2: Ressonância - O próximo dano recebido é convertido em cura;
		Habilidade Suprema: Sentença Divina/Subjugar - Julga o inimigo. O inimigo julgado é executado caso a sua vida atual seja menor que uma porcentagem baseada no tipo do inimigo. Caso sua vida atual seja maior que a necessária para o julgamento, o inimigo é subjugado fazendo com que seus próximos ataques (N turnos) sejam voltados contra si mesmo ou sua equipe (se existir).
}

	- Necromante
{
	 	Passiva: Vampirismo Mágico - Rouba X% da vida atual do adversário com maior quantidade de HP.
	
	Habilidade 1: Desalento Sombrio - Diminui em X% a resistência a danos do adversário e causa dano baseado na sua inteligência.
	
Habilidade 2: Invocação Pútrida - Invoca uma lacaio do submundo que absorverá X de dano provindo de ataques de habilidades ou ataques. Caso, no próximo turno, o lacaio ainda esteja vivo, ele desfere um ataque suicida, explodindo e causando dano aos adversário.
	
	Habilidade Suprema:  Ritual do Guardião do Inferno - Invoca o guardião do submundo, que ataca causando um dano massivo em área.
}



Raça:
	- Elfo
	- Anão
	- Humano
	- Orc
	- Demônio (possível)
	- Ciborgue (secreto)
	- Fada



Itens:
- Poções (Recuperação de pontos de vida e mana e poções para aumentar atributos);
	- Itens ativáveis (Itens variados que podem causar algum efeito ao serem ativados em uma batalha);
	- Equipamentos (Itens que são equipados pelo personagem jogável e proporcionam melhores atributos ao personagem); 




Inimigos:
-	Padrão (um contra um): inimigo possui três dados de seis faces (assim como o jogador).
-	Chefes: o chefe possuirá dados com valores mais altos que o jogador podendo depender do nível e poder do chefe.
-	Lutas em grupo: Três dados de seis faces distribuídos entre os integrantes do grupo inimigo (máximo de três integrantes). Pode variar em lutas contra chefes.


Nota: o banco de dados não está funcionando corretamente, portanto não deve ser possível salvar o jogo.
