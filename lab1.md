Министерство образования Республики Беларусь

Учреждение образования

«Брестский государственный технический университет»

Кафедра ИИТ

Лабораторная работа № 1

По дисциплине «ММПиУ»

Моделирование объекта управления.

Выполнил:

Ст. гр. АС-47

Володько А.C.

Проверил:

Иванюк Д.C.

Брест 2018  На языке C++ реализовать программу, моделирующую рассмотренный выше объект управления, использую эти модели. Использовать ООП, должно быть не менее трех классов (один из них абстрактный) и наследование.

В отчете (файл документации \*.chm, сгенерированный Doxygen) также привести графики изменения температуры объекта, пояснить полученные результаты.

Код программы:

\#include "stdafx.h"

\#include &lt;iostream&gt;

\#include &lt;math.h&gt;

using namespace std;

const double ut = 7.4321;

class Model

{

private:

double array\_y\[31\] = {};

public:

Model() :array\_y() {};

virtual void ShowResult() = 0;

virtual void SearchAnswer() = 0;

};

class LinearModel :public Model

{

private:

double array\_y\[31\];

public:

LinearModel() :array\_y() {}

void SearchAnswer()

{

for (int i = 1; i &lt;= 30; i++)

{

array\_y\[i\] = 0.988\*array\_y\[i - 1\] + 0.232\*ut;

}

}

void ShowResult()

{

cout &lt;&lt; "Решение лийнейной модели: " &lt;&lt; endl;

for (int i = 1; i &lt;= 30; i++)

{

cout &lt;&lt; "t=" &lt;&lt; i &lt;&lt; " y=" &lt;&lt; array\_y\[i\] &lt;&lt; endl;

}

}

};

class NonlinearModel : public Model

{

private:

double array\_y\[31\] = {};

public:

NonlinearModel() :array\_y() {}

void SearchAnswer()

{

for (int i = 1; i &lt;= 30; i++)

{

if (i &gt; 1)

{

array\_y\[i\] = 0.9\*array\_y\[i - 1\] - 0.001\*array\_y\[i - 2\] \* array\_y\[i - 2\] + ut + sin(ut);

}

}

}

void ShowResult()

{

cout &lt;&lt; "Решение нелийнейной модели: " &lt;&lt; endl;

for (int i = 1; i &lt;= 30; i++)

{

cout &lt;&lt; "t=" &lt;&lt; i &lt;&lt; " y=" &lt;&lt; array\_y\[i\] &lt;&lt; endl;

}

}

};

int main()

{

setlocale(0, "");

LinearModel \*ObjectLinearModel = new LinearModel;

NonlinearModel \*ObjectNonlinearModel = new NonlinearModel;

ObjectLinearModel-&gt;SearchAnswer();

ObjectLinearModel-&gt;ShowResult();

ObjectNonlinearModel-&gt;SearchAnswer();

ObjectNonlinearModel-&gt;ShowResult();

system("pause");

return 0;

}
