package com.trx.socketdemo.nio.rpc.provider;

import com.trx.socketdemo.nio.rpc.api.IRpcHelloService;

public class RpcHelloServiceImpl  implements IRpcHelloService {
    @Override
    public String hello(String name) {
        return "Hello "+name+"!";
    }
}
