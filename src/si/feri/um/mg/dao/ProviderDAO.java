package src.si.feri.um.mg.dao;

import src.si.feri.um.mg.dao.interfaces.IProviderDAO;
import src.si.feri.um.mg.vao.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProviderDAO implements IProviderDAO {

    private List<Provider> providers = new ArrayList<>();

    @Override
    public void insertProvider(Provider provider) {
        providers.add(provider);
    }

    @Override
    public Iterable<Provider> getProviders() {
        return providers;
    }

    @Override
    public Optional<Provider> getProviderByEmail(String email) {
        return providers.stream().filter(provider -> provider.getEmail().equals(email)).findFirst();
    }

    @Override
    public void updateProvider(String email, String name) {
        getProviderByEmail(email).ifPresent(provider -> provider.setName(name));
    }

    @Override
    public void deleteProvider(String email) {
        providers.removeIf(provider -> provider.getEmail().equals(email));
    }
}
