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

Брест 2018   
  
  
## Задание:  
На языке C++ реализовать программу, моделирующую объект управления, использую модели. Использовать ООП, должно быть не менее трех классов (один из них абстрактный) и наследование.

В отчете (файл документации \*.chm, сгенерированный Doxygen) также привести графики изменения температуры объекта, пояснить полученные результаты.

### Код программы:
```c++
#include "stdafx.h"
#include <iostream>
#include <math.h>

using namespace std;
const double ut = 7.4321; 

class Model
{
private:
	double array_y[31] = {};
public:
	Model() :array_y() {};
	virtual void ShowResult() = 0;
	virtual void SearchAnswer() = 0;
	

};


class LinearModel :public Model
{
private:
	double array_y[31];
public:
	LinearModel() :array_y() {}
	void SearchAnswer()
	{
		for (int i = 1; i <= 30; i++)
		{
			array_y[i] = 0.988*array_y[i - 1] + 0.232*ut;
		}
	}
	void ShowResult()
	{
		cout << "Решение лийнейной модели: " << endl;
		for (int i = 1; i <= 30; i++)
		{
			cout << "t=" << i << " y=" << array_y[i] << endl;
		}
	}

};

class NonlinearModel : public Model
{
private:
	double array_y[31] = {};
public:
	NonlinearModel() :array_y() {}
	void SearchAnswer()
	{
		for (int i = 1; i <= 30; i++)
		{
			if (i > 1)
			{
				array_y[i] = 0.9*array_y[i - 1] - 0.001*array_y[i - 2] * array_y[i - 2] + ut + sin(ut);
			}
		}
	}
	
	void ShowResult()
	{
		cout << "Решение нелийнейной модели: " << endl;
		for (int i = 1; i <= 30; i++)
		{
			cout << "t=" << i << " y=" << array_y[i] << endl;
		}
	}
};

int main()
{
	setlocale(0, "");
	LinearModel *ObjectLinearModel = new LinearModel;
	NonlinearModel *ObjectNonlinearModel = new NonlinearModel;
	ObjectLinearModel->SearchAnswer();
	ObjectLinearModel->ShowResult();
	ObjectNonlinearModel->SearchAnswer();
	ObjectNonlinearModel->ShowResult();
	system("pause");
	return 0;
}



```
