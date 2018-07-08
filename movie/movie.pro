#-------------------------------------------------
#
# Project created by QtCreator 2018-07-06T15:04:49
#
#-------------------------------------------------

QT       += core gui

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = movie
TEMPLATE = app


SOURCES += main.cpp\
        mywiget.cpp \
    audience.cpp

HEADERS  += mywiget.h \
    audience.h

FORMS    += mywiget.ui

RESOURCES += \
    photo.qrc
