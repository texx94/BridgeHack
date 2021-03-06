package ch.heigvd.mcr.bridgehack.character.races;

import ch.heigvd.mcr.bridgehack.character.roles.Role;
import ch.heigvd.mcr.bridgehack.character.StatModifier;

/**
 * Race specialization: Dwarf
 */
public class Dwarf extends Race {
    /**
     * Constructor for the character
     *
     * @param role the initial role of the character
     */
    public Dwarf(Role role) {
        super(role, new StatModifier(5, 0, -5));
    }

    @Override
    public String toString() {
        return "Dwarf";
    }
}
