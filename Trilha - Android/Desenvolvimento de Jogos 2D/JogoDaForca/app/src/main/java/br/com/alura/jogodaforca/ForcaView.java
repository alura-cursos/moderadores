package br.com.alura.jogodaforca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

public class ForcaView extends PlanoCartesianoView {

    private enum Membro{BRACO, PERNA};
    private enum Lado{DIREITO, ESQUERDO};

    // responsável por armazenar todas as figuras geométricas a serem desenhadas
    private Path pathForca;
    private Paint paintForca;

    private ForcaController forcaController;

    public Path getPathForca() {
        return pathForca;
    }
    public void setPathForca(Path pathForca) {
        this.pathForca = pathForca;
    }
    public Paint getPaintForca() {
        paintForca = new Paint();
        paintForca.setColor(Color.BLACK);
        paintForca.setStyle(Paint.Style.STROKE);
        paintForca.setStrokeWidth(8);
        return paintForca;
    }
    public void setPaintForca(Paint paintForca) {
        this.paintForca = paintForca;
    }

    public ForcaView(Context context) {
        super(context);
    }
    public ForcaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPathForca(new Path());
    }
    public ForcaController getForcaController() {
        return forcaController;
    }
    public void setForcaController(ForcaController forcaController) {
        this.forcaController = forcaController;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        desenhaForca();
        if (getForcaController() != null) {
            switch (getForcaController().getQtdErros()) {
                case 0:
                    desenhaCabeca();
                    break;
                case 1:
                    desenhaCorpo();
                    break;
                case 2:
                    desenhaMembro(Membro.BRACO, Lado.DIREITO);
                    break;
                case 3:
                    desenhaMembro(Membro.BRACO, Lado.ESQUERDO);
                    break;
                case 4:
                    desenhaMembro(Membro.PERNA, Lado.DIREITO);
                    break;
                case 5:
                    desenhaMembro(Membro.PERNA, Lado.ESQUERDO);
                    break;
            }
        }
        drawLetrasCorretas(canvas);
        desenhaTracos();
        canvas.drawPath(getPathForca(), getPaintForca());
    }

    private void desenhaForca() {
        // base
        getPathForca().moveTo(toPixel(1), toPixel(10));
        getPathForca().lineTo(toPixel(3), toPixel(10));

        // poste
        getPathForca().moveTo(toPixel(2), toPixel(10));
        getPathForca().lineTo(toPixel(2), toPixel(1));

        // alca
        getPathForca().rLineTo(toPixel(5), 0);

        // suporte
        getPathForca().rLineTo(0, toPixel(1));
    }


    private void desenhaCabeca() {
        getPathForca().addCircle(toPixel(7), toPixel(3), toPixel(1), Path.Direction.CW);
    }

    private void desenhaCorpo() {
        getPathForca().moveTo(toPixel(7), toPixel(4));
        getPathForca().lineTo(toPixel(7), toPixel(7));
    }

    private void desenhaMembro(Membro membro, Lado lado) {
        final int POSICAO_CORPO = 7;
        final int ALTURA_BRACO = 5;
        final int ALTURA_PERNA = 7;
        int alturaFinal;

        if (membro == Membro.BRACO) {
            getPathForca().moveTo(toPixel(POSICAO_CORPO), toPixel(ALTURA_BRACO));
            alturaFinal = ALTURA_BRACO + 1;
        } else {
            getPathForca().moveTo(toPixel(POSICAO_CORPO), toPixel(ALTURA_PERNA));
            alturaFinal = ALTURA_PERNA + 1;
        }

        if (lado == Lado.DIREITO)
            getPathForca().lineTo(toPixel(POSICAO_CORPO + 1), toPixel(alturaFinal));
        else
            getPathForca().lineTo(toPixel(POSICAO_CORPO - 1), toPixel(alturaFinal));
    }

    private void desenhaTracos() {
        int eixoX = toPixel(3);
        getPathForca().moveTo(eixoX + 10, toPixel(10));
        if (getForcaController() == null)
            return;
        for (int i = 0; i <= getForcaController().getPalavraAteAgora().length() - 1; i++) {
            getPathForca().rMoveTo(10, 0);
            getPathForca().rLineTo(toPixel(1), 0);
        }
    }

    private void drawLetrasCorretas(Canvas canvas) {
        int eixoX = toPixel(3);
        getPathForca().moveTo(eixoX + 10, toPixel(10));
        eixoX += 35;

        if (getForcaController() == null)
            return;

        for (int i = 0; i <= getForcaController().getPalavraAteAgora().length() - 1; i++) {
            char c = getForcaController().getPalavraAteAgora().charAt(i);
            canvas.drawText(c + "", eixoX + ((toPixel(1) + 10) * i), toPixel(10) - 15, getPaintTraco());
        }
    }

    private Paint getPaintTraco() {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        paint.setTextSize(25);
        return paint;
    }

}
