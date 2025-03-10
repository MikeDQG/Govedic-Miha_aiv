package src.si.feri.um.mg.dao;

import src.si.feri.um.mg.dao.interfaces.IProviderDAO;
import src.si.feri.um.mg.vao.Provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProviderDAO implements IProviderDAO {

    private static volatile ProviderDAO instance;

    private ProviderDAO() {}

    private final List<Provider> providers = Collections.synchronizedList(new ArrayList<>());

    public static ProviderDAO getInstance() {
        if (instance == null) {
            synchronized (ProviderDAO.class) {
                if (instance == null) {
                    instance = new ProviderDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public void insertProvider(Provider provider) {
        synchronized (providers) {
            providers.add(provider);
        }
    }

    @Override
    public List<Provider> getProviders() {
        synchronized (providers) {
            return providers;
        }
    }

    @Override
    public Optional<Provider> getProviderByEmail(String email) {
        synchronized (providers) {
            return providers.stream().filter(provider -> provider.getEmail().equals(email)).findFirst();
        }
    }

    @Override
    public void updateProvider(String email, String name) {
        synchronized (providers) {
            getProviderByEmail(email).ifPresent(provider -> provider.setName(name));
        }
    }

    @Override
    public void deleteProvider(String email) {
        synchronized (providers) {
            providers.removeIf(provider -> provider.getEmail().equals(email));
        }
    }
}
