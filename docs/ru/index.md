## Быстрый старт

1. Установить [Java Development Kit 12][jdk] и [SBT][sbt]
2. Если вы собираетесь использовать модели практик OMG Essence, то установить картинки [semod-plantuml][semod-plantuml]
3. Создать проект модели из шаблона [smeagol74/semod.g8][g8]
```shell script
$ sbt new smeagol74/semod.g8
```

## Возможности

### Языки моделирования

#### Произвольные онтики (сущности и их связи)

![Пример онтики](../../src/test/puml/ontology/Ex_Ontology.svg)

[Подробнее...](ontology)

#### Системных разбиения (системы, их роли и структура)

![Пример системного разбиения](../../src/test/puml/system/Ex_Systems.svg)

[Подробнее...](system)

#### Практик OMG Essence (альфы, состояния, рабочие документы, практики)

[Подробнее...](essence)

#### Архитектура OpenGroup Archimate (слои, деятельности, связи)

![Пример Archimate](../../src/test/puml/archimate/Ex_18_StakeholderDriverAndAssessment.svg)

[Подробнее...](archimate)

## Функциональные возможности

```scala
//TODO
```

[semod-plantuml]: https://github.com/smeagol74/semod-plantuml
[sbt]: https://www.scala-sbt.org/
[jdk]: https://jdk.java.net/12/
[g8]: https://github.com/smeagol74/semod.g8
