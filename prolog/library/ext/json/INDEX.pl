/*  Creator: make/0

    Purpose: Provide index for autoload
*/

index(json_read(?,?), json, json).
index(json_read(?,?,?), json, json).
index(atom_json_term(?,?,?), json, json).
index(json_write(?,?), json, json).
index(json_write(?,?,?), json, json).
index(is_json_term(?), json, json).
index(is_json_term(?,?), json, json).
index(json_read_dict(?,?), json, json).
index(json_read_dict(?,?,?), json, json).
index(json_write_dict(?,?), json, json).
index(json_write_dict(?,?,?), json, json).
index(atom_json_dict(?,?,?), json, json).
index(json(?,?,?,?), json, json).
index(prolog_to_json(:,-), json_convert, json_convert).
index(json_to_prolog(+,:), json_convert, json_convert).
index(json_object(?), json_convert, json_convert).
index(:(op,op(1150,fx,json_object)), json_convert, json_convert).
index(json_token(?,?,?), json_grammar, json_grammar).
