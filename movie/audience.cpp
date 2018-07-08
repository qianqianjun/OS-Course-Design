#include "audience.h"
#include <QDebug>
#include <QTime>

audience::audience(QObject *parent) : QThread(parent)
{

}

void audience::run()
{
        //ui->m1->setPixmap(QPixmap("://photo/m1.jpg"));
        //MyWiget::ui->m1->setPixmap(QPixmap("://photo/m1.jpg"));

        for(int i=0;i<30;i++){
        QTime t;
        t= QTime::currentTime();
        qsrand(t.msec()+t.second()*1000);
        int k = qrand()%3;
        sleep(k*2);//qDebug()<<"k= "<<k;

        QString tmp = QString("ABCDEFGHIJKLMNOPQRSTUVWZYZ");
        QString S = QString();
        //QTime t;
        //t= tQTime::currenTime();
        qsrand(t.msec()+t.second()*1000);
        for(int i=0;i<8;i++) {
            int ir = qrand()%tmp.length();
            S[i] = tmp.at(ir);
        }

        //qsrand(t.msec()+t.second()*1000);
        //int n = qrand()%9+1;
        qDebug()<<"k= "<<k<<" #"<<thread()->currentThreadId();
        emit isDone(k,S);

        }
}
