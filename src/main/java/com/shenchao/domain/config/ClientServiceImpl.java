package com.shenchao.domain.config;

/**
 * Created by shenchao on 2017/1/30.
 */
public class ClientServiceImpl implements ClientService{
    private ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    @Override
    public void print() {
        System.out.println(clientDao+".....");
    }
}
