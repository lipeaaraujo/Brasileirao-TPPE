# Brasileirão - TPPE

Sistema de simulação de campeonato de futebol no formato de pontos corridos, desenvolvido em Java.

## Descrição

Aplicação que simula um campeonato de futebol com sistema de rodadas, partidas e classificação automática. Implementa as regras oficiais de classificação incluindo pontuação, saldo de gols, confronto direto e critérios de desempate por cartões.

## Funcionalidades

- Geração automática de rodadas (turno e returno)
- Registro de partidas com gols e cartões
- Classificação automática com critérios de desempate:
  - Pontos (vitória: 3pts, empate: 1pt)
  - Número de vitórias
  - Saldo de gols
  - Gols pró
  - Confronto direto
  - Cartões (menor quantidade de vermelhos e amarelos)

## Estrutura

```
src/
├── campeonato/
│   ├── Campeonato.java    # Gerenciamento do campeonato
│   ├── Time.java          # Dados e estatísticas dos times
│   ├── Partida.java       # Lógica de partidas
│   └── Rodada.java        # Agrupamento de partidas
└── tests/                 # Testes unitários (JUnit)
```

## Como usar

### Compilar
```bash
javac -d bin src/campeonato/*.java src/tests/*.java
```

### Executar testes
```bash
java -cp bin:lib/* org.junit.runner.JUnitCore tests.AllTests
```

## Testes

O projeto inclui testes para:
- Sistema de pontuação
- Critérios de desempate
- Vitórias, gols e saldos
- Geração de rodadas

## Disciplina

**Técnicas de Programação em Plataformas Emergentes**  
Universidade de Brasília (UnB)
