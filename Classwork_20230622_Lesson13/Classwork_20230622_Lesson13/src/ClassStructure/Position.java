package ClassStructure;

public enum Position {
    DIRECTOR,
    CHIEF_ACCOUNTANT,
    ACCOUNTANT,
    TEAM_LEAD,
    DEVELOPER,
    SALES_MANAGER,
    SECURITY_GUARD;

    public static Position getNewPosition(Position oldPosition) {
        if (CHIEF_ACCOUNTANT.equals(oldPosition) || TEAM_LEAD.equals(oldPosition) || SALES_MANAGER.equals(oldPosition)) {
            return DIRECTOR;
        } else if (ACCOUNTANT.equals(oldPosition)) {
            return CHIEF_ACCOUNTANT;
        } else if (DEVELOPER.equals(oldPosition)) {
            return TEAM_LEAD;
        } else {
            return oldPosition;
        }
    }
}
