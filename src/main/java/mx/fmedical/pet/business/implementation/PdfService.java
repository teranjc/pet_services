package mx.fmedical.pet.business.implementation;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class PdfService {

    public byte[] generatePdf() {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add logo
            Image logo = Image.getInstance("/home/desarrollo/Descargas/LogoSUIM.png"); // Cambia esto por la ruta de tu logo
            logo.scaleToFit(80, 80);
            document.add(logo);

            // Add title
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLACK);
            Paragraph title = new Paragraph("FICHA CLÍNICA VETERINARIA", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Add header info
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.setSpacingBefore(10f);
            headerTable.setSpacingAfter(10f);

            addHeaderCell(headerTable, "Fecha: " + Date.from(Instant.now()));
            addHeaderCell(headerTable, "N° ficha: DEV-15");

            document.add(headerTable);

            // Add owner and patient info
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            addTableHeader(table, "PROPIETARIO");
            addTableHeader(table, "PACIENTE");

            addRow(table, "Nombre:", "Nombre:");
            addRow(table, "Rut:", "Especie:");
            addRow(table, "Teléfono:", "Raza:");
            addRow(table, "Correo:", "Sexo:");
            addRow(table, "", "Edad:");
            addRow(table, "", "Peso:");

            document.add(table);

            // Add motivo de consulta and anamnesis in the same row
            PdfPTable motivoAnamnesisTable = new PdfPTable(2);
            motivoAnamnesisTable.setWidthPercentage(100);
            motivoAnamnesisTable.setSpacingBefore(10f);
            motivoAnamnesisTable.setSpacingAfter(10f);

            PdfPCell motivoCell = new PdfPCell(new Phrase("Motivo de consulta:", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK)));
            motivoCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            motivoCell.setBorder(PdfPCell.NO_BORDER);
            motivoAnamnesisTable.addCell(motivoCell);

            PdfPCell anamnesisCell = new PdfPCell(new Phrase("Anamnesis:", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK)));
            anamnesisCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            anamnesisCell.setBorder(PdfPCell.NO_BORDER);
            motivoAnamnesisTable.addCell(anamnesisCell);

            document.add(motivoAnamnesisTable);

            // Add anamnesis table
            PdfPTable anamnesisTable = new PdfPTable(1);
            anamnesisTable.setWidthPercentage(100);
            anamnesisTable.setSpacingBefore(10f);
            anamnesisTable.setSpacingAfter(10f);

            addRow(anamnesisTable, "Remota:", "");
            addRow(anamnesisTable, "Reciente:", "");

            document.add(anamnesisTable);

            PdfPTable inspectionTable = new PdfPTable(2);
            inspectionTable.setWidthPercentage(100);
            inspectionTable.setSpacingBefore(10f);
            inspectionTable.setSpacingAfter(10f);

            addInspectionCell(inspectionTable, "Inspección general", "Examen clínico");
            addRow(inspectionTable, "Nivel atención al medio", "Hidratación");
            addRow(inspectionTable, "Conducta", "Observaciones");
            addRow(inspectionTable, "Marcha", "");
            addRow(inspectionTable, "Estado nutricional", "");

            document.add(inspectionTable);

            // Add constants and diagnosis section
            PdfPTable constantsTable = new PdfPTable(2);
            constantsTable.setWidthPercentage(100);
            constantsTable.setSpacingBefore(10f);
            constantsTable.setSpacingAfter(10f);

            addConstantsHeader(constantsTable, "Constantes vitales", "");
            addRow(constantsTable, "FR:", "FC:");
            addRow(constantsTable, "TEMP:", "");
            addRow(constantsTable, "TRC:", "TPG:");

            document.add(constantsTable);

            addSectionTitle(document, "Evaluación del caso:");

            PdfPTable evaluationTable = new PdfPTable(1);
            evaluationTable.setWidthPercentage(100);
            evaluationTable.setSpacingBefore(10f);
            evaluationTable.setSpacingAfter(10f);

            addRow(evaluationTable, "Exámenes complementarios", "");
            addRow(evaluationTable, "Diagnósticos diferenciales", "");
            addRow(evaluationTable, "Diagnóstico definitivo", "");
            addRow(evaluationTable, "Tratamiento y recomendaciones", "");

            document.add(evaluationTable);

            // Add image in the bottom right
            PdfPTable imageTable = new PdfPTable(2);
            imageTable.setWidthPercentage(100);
            imageTable.setSpacingBefore(10f);

            PdfPCell leftCell = new PdfPCell();
            leftCell.setBorder(Rectangle.NO_BORDER);
            imageTable.addCell(leftCell);

            Image img = Image.getInstance("/home/desarrollo/Imágenes/perros.png"); // Cambia esto por la ruta de tu imagen
            img.scaleToFit(100, 100);
            PdfPCell imageCell = new PdfPCell(img);
            imageCell.setBorder(Rectangle.NO_BORDER);
            imageCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            imageTable.addCell(imageCell);

            document.add(imageTable);

            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

    private void addHeaderCell(PdfPTable table, String content) {
        PdfPCell cell = new PdfPCell(new Phrase(content));
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);
    }

    private void addTableHeader(PdfPTable table, String header) {
        Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase(header, headFont));
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
    }

    private void addInspectionCell(PdfPTable table, String leftHeader, String rightHeader) {
        PdfPCell left = new PdfPCell(new Phrase(leftHeader));
        left.setPadding(5);
        left.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(left);

        PdfPCell right = new PdfPCell(new Phrase(rightHeader));
        right.setPadding(5);
        right.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(right);
    }

    private void addConstantsHeader(PdfPTable table, String leftHeader, String rightHeader) {
        PdfPCell left = new PdfPCell(new Phrase(leftHeader));
        left.setPadding(5);
        table.addCell(left);

        PdfPCell right = new PdfPCell(new Phrase(rightHeader));
        right.setPadding(5);
        table.addCell(right);
    }

    private void addRow(PdfPTable table, String leftCell, String rightCell) {
        PdfPCell left = new PdfPCell(new Phrase(leftCell));
        left.setPadding(5);
        table.addCell(left);

        PdfPCell right = new PdfPCell(new Phrase(rightCell));
        right.setPadding(5);
        table.addCell(right);
    }

    private void addSectionTitle(Document document, String title) throws DocumentException {
        Font sectionFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
        Paragraph sectionTitle = new Paragraph(title, sectionFont);
        sectionTitle.setSpacingBefore(10f);
        sectionTitle.setSpacingAfter(5f);
        document.add(sectionTitle);
    }
}
