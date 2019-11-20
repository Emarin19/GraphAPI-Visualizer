package cr.ac.tec.dto;

import cr.ac.tec.objects.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DB {
    public static Map<UUID, Graph> db = new HashMap();
}
