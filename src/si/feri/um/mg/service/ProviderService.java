package src.si.feri.um.mg.service;

import src.si.feri.um.mg.InstanceNotFoundException;
import src.si.feri.um.mg.dao.ProviderDAO;
import src.si.feri.um.mg.dao.interfaces.IProviderDAO;
import src.si.feri.um.mg.vao.Provider;

import java.util.List;
import java.util.Optional;

public class ProviderService {

    private final IProviderDAO providerDAO = ProviderDAO.getInstance();

    public Provider createProvider(String name, String email) throws IllegalArgumentException {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        Provider provider = new Provider(name, email);
        providerDAO.insertProvider(provider);
        return provider;
    }

    public List<Provider> getAllProviders() {
        return providerDAO.getProviders();
    }

    public Provider getProvider(String email) throws IllegalArgumentException, InstanceNotFoundException {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        Optional<Provider> provider = providerDAO.getProviderByEmail(email);
        if (provider.isEmpty()) {
            throw new InstanceNotFoundException("No such provider");
        }
        return provider.get();
    }

    public boolean updateProvider(String email, String name) {
        if (email == null || email.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Email/name cannot be null or empty");
        }
        try {
            getProvider(email);
            providerDAO.updateProvider(email, name);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteProvider(String email) throws IllegalArgumentException {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        try {
            getProvider(email);
            providerDAO.deleteProvider(email);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
