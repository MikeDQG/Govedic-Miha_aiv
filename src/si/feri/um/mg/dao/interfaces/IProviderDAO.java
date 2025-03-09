package src.si.feri.um.mg.dao.interfaces;

import src.si.feri.um.mg.vao.Provider;

import java.util.Optional;

public interface IProviderDAO {
    void insertProvider(Provider provider);
    Iterable<Provider> getProviders();
    Optional<Provider> getProviderByEmail(String email);
    void updateProvider(String email, String name);
    void deleteProvider(String email);
}
