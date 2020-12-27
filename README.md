# Code-Sharing-Platform

Sometimes, it's convenient to have a tool that can help programmers share a **snippet of code** with 
each other. There's actually a website known as [Pastebin](https://pastebin.com) that 
does perfectly the same. The problem with this platform, is that every piece of code you publish 
there, become automatically available for everyone. So to exclude this problem, we implement our own 
code sharing platform which could have a restriction for a shared snippet of code.

This project is based on **Spring Boot**, thereby we develop two types of interfaces: **API** and **Web** 
interface. The _API_ is acceded through endpoints that start with `/api` while _web_ interface 
endpoints start with `/`. The _API_ interface return data as Json while the _web_ interface 
use _HTML_, _JavaScript_, and _CSS_.

**FreeMarker** is used to generate HTML template engine. It's a Java based template engine, 
focusing on dynamic web page generation with _MVC_ software architecture. The main profit 
of using FreeMarker is the complete separation of the presentation layer and the business 
layer.

`</>`
