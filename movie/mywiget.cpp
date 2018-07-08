#include "mywiget.h"
#include "ui_mywiget.h"
#include <QSemaphore>
#include <QThread>
#include <QDebug>
#include <QTime>
//#include <QString>


QSemaphore sem1(1);
QSemaphore sem2(1);
QSemaphore sem3(1);
QSemaphore T(1);
QSemaphore Fuck(1);
static int n1 = 0;  //how many people in theater1
static int n2 = 0;
static int n3 = 0;
static int mov1 = 0; //what's on in theater 1
static int mov2 = 0;
static int mov3 = 0;
static int n0=0;


MyWiget::MyWiget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::MyWiget)
{
    ui->setupUi(this);thread1 = new audience(this);

    thread1 = new audience(this);
    thread2 = new audience(this);
    thread3 = new audience(this);
    thread4 = new audience(this);
    thread5 = new audience(this);
    thread6 = new audience(this);
    thread7 = new audience(this);
    thread8 = new audience(this);
    thread9 = new audience(this);
    thread10 = new audience(this);
    thread11 = new audience(this);
    thread12 = new audience(this);
    thread13 = new audience(this);
    thread14 = new audience(this);
    thread15 = new audience(this);
    thread16 = new audience(this);
    thread17 = new audience(this);
    thread18 = new audience(this);
    thread19 = new audience(this);
    thread20 = new audience(this);
    thread21 = new audience(this);
    thread22 = new audience(this);
    thread23 = new audience(this);
    thread24 = new audience(this);
    thread25 = new audience(this);
    thread26 = new audience(this);
    thread27 = new audience(this);
    thread28 = new audience(this);
    thread29 = new audience(this);
    thread30 = new audience(this);
    thread31 = new audience(this);
    thread32 = new audience(this);
    thread33 = new audience(this);
    thread34 = new audience(this);
    thread35 = new audience(this);
    thread36 = new audience(this);
    thread37 = new audience(this);
    thread38 = new audience(this);
    thread39 = new audience(this);
    thread40 = new audience(this);

    connect(thread1, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread2, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread3, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread4, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread5, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread6, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread7, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread8, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread9, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread10, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread11, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread12, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread13, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread14, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread15, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread16, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread17, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread18, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread19, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread20, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread21, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread22, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread23, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread24, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread25, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread26, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread27, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread28, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread29, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread30, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread31, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread32, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread33, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread34, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread35, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread36, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread37, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread38, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread39, &audience::isDone, this, &MyWiget::dealDone);
    connect(thread40, &audience::isDone, this, &MyWiget::dealDone);

//connect(this, &MyWiget::hello, thread1, &audience::run);
}

MyWiget::~MyWiget()
{
    delete ui;
}

void MyWiget::dealDone(int nl,QString S)
{

    for(int i=0 ; i<10 ;i++){
        QTime t;
        t= QTime::currentTime();

        qsrand(t.msec()+t.second()*1000);
        int n = qrand()%9+1;
        n0=n;
    int tiaoguo=0;
    ui->lineEdit->setText(S+" come");
    //sem1.acquire();
    t= QTime::currentTime();
    qsrand(t.msec()+t.second()*1000);
    int choice=qrand()%3;
    switch (choice) {
    case 0:
    {
     if(n0==0)
     {  ui->m1->setPixmap(QPixmap("://photo/black.jpg"));}
     else if(n0==1)
     {  ui->m1->setPixmap(QPixmap("://photo/m1.jpg"));}
     else if(n0==2)
     {  ui->m1->setPixmap(QPixmap("://photo/m2.jpg"));}
     else if(n0==3)
     {  ui->m1->setPixmap(QPixmap("://photo/m3.jpg"));}
     else if(n0==4)
     {  ui->m1->setPixmap(QPixmap("://photo/m4.jpg"));}
     else if(n0==5)
     {  ui->m1->setPixmap(QPixmap("://photo/m5.jpg"));}
     else if(n0==6)
     {  ui->m1->setPixmap(QPixmap("://photo/m6.jpg"));}
     else if(n0==7)
     {  ui->m1->setPixmap(QPixmap("://photo/m7.jpg"));}
     else if(n0==8)
     {  ui->m1->setPixmap(QPixmap("://photo/m8.jpg"));}
     else if(n0==9)
     {  ui->m1->setPixmap(QPixmap("://photo/m9.jpg"));}
     ui->m1->setScaledContents(true);
     n1++;
     mov1=n0;
     tiaoguo=1;
 }

 {
    if(mov1==n0)
    {n1++;tiaoguo=1;}
    else
    {
         tiaoguo=0;
    }
 }
        break;
     case 1:{

        if(n0==0)
        {  ui->m2->setPixmap(QPixmap("://photo/black.jpg"));}
        else if(n0==1)
        {  ui->m2->setPixmap(QPixmap("://photo/m1.jpg"));}
        else if(n0==2)
        {  ui->m2->setPixmap(QPixmap("://photo/m2.jpg"));}
        else if(n0==3)
        {  ui->m2->setPixmap(QPixmap("://photo/m3.jpg"));}
        else if(n0==4)
        {  ui->m2->setPixmap(QPixmap("://photo/m4.jpg"));}
        else if(n0==5)
        {  ui->m2->setPixmap(QPixmap("://photo/m5.jpg"));}
        else if(n0==6)
        {  ui->m2->setPixmap(QPixmap("://photo/m6.jpg"));}
        else if(n==7)
        {  ui->m2->setPixmap(QPixmap("://photo/m7.jpg"));}
        else if(n0==8)
        {  ui->m2->setPixmap(QPixmap("://photo/m8.jpg"));}
        else if(n0==9)
        {  ui->m2->setPixmap(QPixmap("://photo/m9.jpg"));}
        ui->m2->setScaledContents(true);
        n2++;
        mov2=n0;
        tiaoguo=1;
    }

    {
       if(mov2==n0)
       {n2++;tiaoguo=1;}
       else
       {
           tiaoguo=0;
       }
    } break;
    case 2:
    {

        if(n0==0)
        {  ui->m3->setPixmap(QPixmap("://photo/black.jpg"));}
        else if(n0==1)
        {  ui->m3->setPixmap(QPixmap("://photo/m1.jpg"));}
        else if(n0==2)
        {  ui->m3->setPixmap(QPixmap("://photo/m2.jpg"));}
        else if(n0==3)
        {  ui->m3->setPixmap(QPixmap("://photo/m3.jpg"));}
        else if(n0==4)
        {  ui->m3->setPixmap(QPixmap("://photo/m4.jpg"));}
        else if(n0==5)
        {  ui->m3->setPixmap(QPixmap("://photo/m5.jpg"));}
        else if(n0==6)
        {  ui->m3->setPixmap(QPixmap("://photo/m6.jpg"));}
        else if(n0==7)
        {  ui->m3->setPixmap(QPixmap("://photo/m7.jpg"));}
        else if(n0==8)
        {  ui->m3->setPixmap(QPixmap("://photo/m8.jpg"));}
        else if(n0==9)
        {  ui->m3->setPixmap(QPixmap("://photo/m9.jpg"));}
        ui->m3->setScaledContents(true);
        n3++;
        mov3=n;
    }

    {
       if(mov3==n0)
       {n3++;}
       else
       {
           ;
       }
    } break;
//sem3.release();


//ui->lineEdit->setText(S+" leave");
/*
if(n0==mov1)
{
    //sem1.acquire();
    n1--;
    //sem1.release();
}
if(n0==mov2)
{
    //sem1.acquire();
    n2--;
    //sem1.release();
}
if(n0==mov3)
{
    //sem1.acquire();
    n3--;
    //sem1.release();
}
*/
    default:
        break;
    }

        //sem1.release();


        //sem2.acquire();


        //sem2.release();




        //sem3.acquire();


        //if(n1==0 || n2==0 || n3==0)
        tiaoguo=0;
     //QThread::msleep(1000);
    }
}

void MyWiget::on_pushButton_clicked()
{
            //dealDone(1,"hahah");


            /*
            QTime t;
            t= QTime::currentTime();

            T.acquire();
            qsrand(t.msec()+t.second()*1000);
            int n = qrand()%9+1;
            n0=n;
            qDebug()<<"n0= "<<n0;
            if(n1==0 || n2==0 || n3==0 || mov1==n0 || mov2==n0 || mov3==n0)
               {
                thread1->start();
               }
            else
                {
                    ;
                }
            thread1->quit();
            //QThread::sleep(3);
            T.release();
            */

            /*
            t= QTime::currentTime();
            T.acquire();
            qsrand(t.msec()+t.second()*1000);
            n = qrand()%9+1;
            n0=n;
            qDebug()<<"n0= "<<n0;
            if(n1==0 || n2==0 || n3==0 || mov1==n0 || mov2==n0 || mov3==n0)
               {
                thread2->start();
               }
            else
                {
                    ;
                }
            thread2->quit();
            //QThread::sleep(1);
            T.release();
            */


            /*
            t= QTime::currentTime();
            T.acquire();
            qsrand(t.msec()+t.second()*1000);
            n = qrand()%9+1;
            n0=n;
            qDebug()<<"n0= "<<n0;
            if(n1==0 || n2==0 || n3==0 || mov1==n0 || mov2==n0 || mov3==n0)
               {
                thread3->start();
               }
            else
                {
                    ;
                }
            thread3->quit();
            QThread::sleep(1);
            T.release();

            t= QTime::currentTime();
            T.acquire();
            qsrand(t.msec()+t.second()*1000);
            n = qrand()%9+1;
            n0=n;
            qDebug()<<"n0= "<<n0;
            if(n1==0 || n2==0 || n3==0 || mov1==n0 || mov2==n0 || mov3==n0)
               {
                thread4->start();
               }
            else
                {
                    ;
                }
            thread4->quit();
            QThread::sleep(1);
            T.release();

            t= QTime::currentTime();
            T.acquire();
            qsrand(t.msec()+t.second()*1000);
            n = qrand()%9+1;
            n0=n;
            qDebug()<<"n0= "<<n0;
            if(n1==0 || n2==0 || n3==0 || mov1==n0 || mov2==n0 || mov3==n0)
               {
                thread5->start();
               }
            else
                {
                    ;
                }
            thread5->quit();
            T.release();

            t= QTime::currentTime();
            T.acquire();
            qsrand(t.msec()+t.second()*1000);
            n = qrand()%9+1;
            n0=n;
            qDebug()<<"n0= "<<n0;
            if(n1==0 || n2==0 || n3==0 || mov1==n0 || mov2==n0 || mov3==n0)
               {
                thread6->start();
               }
            else
                {
                    ;
                }
            thread6->quit();
            QThread::sleep(1);
            T.release();

            t= QTime::currentTime();
            T.acquire();
            qsrand(t.msec()+t.second()*1000);
            n = qrand()%9+1;
            n0=n;
            qDebug()<<"n0= "<<n0;
            if(n1==0 || n2==0 || n3==0 || mov1==n0 || mov2==n0 || mov3==n0)
               {
                thread7->start();
               }
            else
                {
                    ;
                }
            thread7->quit();
            QThread::sleep(1);
            T.release();
*/





        thread1->start();
        thread2->start();
        thread3->start();
        thread4->start();
        thread5->start();
        thread6->start();
        thread7->start();
        thread8->start();
        thread9->start();
        thread10->start();
        thread11->start();
        thread12->start();
        thread13->start();
        thread14->start();
        thread15->start();
        thread16->start();
        thread17->start();
        thread18->start();
        thread19->start();
        thread20->start();
        thread21->start();
        thread22->start();
        thread23->start();
        thread24->start();
        thread25->start();
        thread26->start();
        thread27->start();
        thread28->start();
        thread29->start();
        thread30->start();
        thread31->start();
        thread32->start();
        thread33->start();
        thread34->start();
        thread35->start();
        thread36->start();
        thread37->start();
        thread38->start();
        thread39->start();
        thread40->start();

        thread1->quit();
        thread2->quit();
        thread3->quit();
        thread4->quit();
        thread5->quit();
        thread6->quit();
        thread7->quit();
        thread8->quit();
        thread9->quit();
        thread10->quit();
        thread11->quit();
        thread12->quit();
        thread13->quit();
        thread14->quit();
        thread15->quit();
        thread16->quit();
        thread17->quit();
        thread18->quit();
        thread19->quit();
        thread20->quit();
        thread21->quit();
        thread22->quit();
        thread23->quit();
        thread24->quit();
        thread25->quit();
        thread26->quit();
        thread27->quit();
        thread28->quit();
        thread29->quit();
        thread30->quit();
        thread31->quit();
        thread32->quit();
        thread33->quit();
        thread34->quit();
        thread35->quit();
        thread36->quit();
        thread37->quit();
        thread38->quit();
        thread39->quit();
        thread40->quit();

}
