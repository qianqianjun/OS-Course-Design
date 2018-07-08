#ifndef MYWIGET_H
#define MYWIGET_H

#include <QWidget>
#include "audience.h"


namespace Ui {
class MyWiget;
}

class MyWiget : public QWidget
{
    Q_OBJECT

signals:
    //void hello(MyWiget *ui);

public:

    explicit MyWiget(QWidget *parent = 0);
    ~MyWiget();
    audience *thread1;
    audience *thread2;
    audience *thread3;
    audience *thread4;
    audience *thread5;
    audience *thread6;
    audience *thread7;
    audience *thread8;
    audience *thread9;
    audience *thread10;
    audience *thread11;
    audience *thread12;
    audience *thread13;
    audience *thread14;
    audience *thread15;
    audience *thread16;
    audience *thread17;
    audience *thread18;
    audience *thread19;
    audience *thread20;
    audience *thread21;
    audience *thread22;
    audience *thread23;
    audience *thread24;
    audience *thread25;
    audience *thread26;
    audience *thread27;
    audience *thread28;
    audience *thread29;
    audience *thread30;
    audience *thread31;
    audience *thread32;
    audience *thread33;
    audience *thread34;
    audience *thread35;
    audience *thread36;
    audience *thread37;
    audience *thread38;
    audience *thread39;
    audience *thread40;
    void dealDone(int n, QString S);


private slots:
    void on_pushButton_clicked();

private:
    Ui::MyWiget *ui;
};

#endif // MYWIGET_H
