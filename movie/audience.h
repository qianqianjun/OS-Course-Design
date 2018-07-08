#ifndef AUDIENCE_H
#define AUDIENCE_H

#include <QString>
#include <QThread>
#include <QSemaphore>


class audience : public QThread
{
    Q_OBJECT
public:
    explicit audience(QObject *parent = 0);
    //void dealarg(MyWiget *ui);
private:
    void run();


signals:
    void isDone(int n,QString s);
    //void isDone2(int n);

public slots:
};

#endif // AUDIENCE_H
