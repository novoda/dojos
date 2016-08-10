package com.pss;

abstract class Move implements Visitor {
    abstract Move accept(Visitor visitor);
}
