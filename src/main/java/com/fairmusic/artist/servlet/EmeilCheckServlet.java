package com.fairmusic.artist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fairmusic.artist.service.ArtistServiceimpl;

@WebServlet(name = "emeilCheck", urlPatterns = { "/emailCheck.do" })
public class EmeilCheckServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("������ ����~");
		response.setContentType("text/html;charset=euc-kr");
		response.setHeader("cache-control", "no-cache, no-store");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("artist_email");
		System.out.println("������"+email);
		ArtistServiceimpl service = new ArtistServiceimpl();
		boolean check = service.emailCheck(email);
		String msg = "";
		if(check==true){
			msg = "�̹� ������� �̸��� �Դϴ�.";
		}else{
			msg = "��밡��~";
		}
		pw.write(msg);
	}

}