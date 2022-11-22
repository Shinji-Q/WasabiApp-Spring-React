package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.model.Usuario;
import com.wassabi.wassabiapp.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public @ResponseBody Iterable<Usuario> getUsuario(){
        return usuarioService.getAllUsuario();
    }

    @GetMapping("usuario/{usuario_id}")
    public Usuario getUsuario(@PathVariable int usuario_id){
        return usuarioService.getUsuario(usuario_id);
    }

    @GetMapping("usuario/email/{usuarioEmail}")
    public Usuario getUsuario(@PathVariable String usuarioEmail){
        return usuarioService.getUsuariobyEmail(usuarioEmail);
    }

    @RequestMapping(value = "/usuario", params = {"usuarioEmail", "usuarioSenha"}, method = RequestMethod.GET)
    public Usuario getUsuario(@RequestParam("usuarioEmail") String usuarioEmail, @RequestParam("usuarioSenha") String usuarioSenha){
        Usuario usuario = usuarioService.getUsuariobyEmail(usuarioEmail);
        if (usuario.getUsuarioSenha().equals(usuarioSenha)) {
            return usuario;
        } else {
            return null;
        }
    }

    @PostMapping("/usuario")
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        usuario = this.usuarioService.saveUsuario(usuario);

        return usuario;
    }

    @PutMapping("/usuario")
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/usuario")
    public void deleteUsuario(@RequestBody Usuario usuario){
        usuarioService.deleteUsuario(usuario);
    }
    
}
